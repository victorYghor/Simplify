package com.simplify.simplify

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.simplify.simplify.model.FirstStates
import com.simplify.simplify.model.UserSettings
import com.simplify.simplify.model.UserSettingsSerializer
import com.simplify.simplify.model.userSettingDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _dataStoreIsLoading = MutableStateFlow<Boolean>(true)
    val dataStoreIsLoading = _dataStoreIsLoading.asStateFlow()

    private val _userSettings = MutableStateFlow(UserSettings())
    val userSettings = viewModelScope.async {
        userSettingsDataStore.data.collectLatest { data ->
            _userSettings.update {
                it.copy(
                    isFirstAccess = if (data.isFirstAccess == FirstStates.LOADING)
                        FirstStates.FIRST_ACCESS
                    else
                        data.isFirstAccess
                )
            }
        }
        _userSettings.asStateFlow()
    }

    suspend fun retrieveDataStore(): FirstStates {
        return viewModelScope.async {
            if (userSettings.isCompleted) {
                _dataStoreIsLoading.update {
                    false
                }
            }
            userSettings.await().value.isFirstAccess
        }.await()
    }

    private val userSettingsDataStore: DataStore<UserSettings>
        get() = getApplication<Application>().applicationContext.userSettingDataStore


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
                        isFirstAccess = FirstStates.OTHER
                    )
                }
            }
        }
    }
}