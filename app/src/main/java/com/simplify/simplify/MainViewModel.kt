package com.simplify.simplify

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.simplify.simplify.model.IsFirstAccess
import com.simplify.simplify.model.UserSettings
import com.simplify.simplify.model.UserSettingsSerializer
import com.simplify.simplify.model.userSettingDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _userSettings = MutableStateFlow(UserSettings())
    val userSettings = _userSettings.asStateFlow()

    private val userSettingsDataStore: DataStore<UserSettings>
        get() = getApplication<Application>().applicationContext.userSettingDataStore

    var isUserAccess: Job? = null

    init {
       isUserAccess = viewModelScope.launch(Dispatchers.IO) {
            userSettingsDataStore.data.collectLatest { data ->
                _userSettings.update {
                    it.copy(
                        isFirstAccess = data.isFirstAccess
                    )
                }
            }
        }
    }

    fun resetData() {
        viewModelScope.launch(Dispatchers.IO) {
            userSettingsDataStore.updateData { UserSettingsSerializer.defaultValue }
        }
    }

    fun endFirstTime() {
        viewModelScope.launch(Dispatchers.IO) {
            userSettingsDataStore.data.collectLatest {
                _userSettings.update {
                    it.copy(
                        isFirstAccess = IsFirstAccess.NORMAL
                    )
                }
            }
        }
    }
}