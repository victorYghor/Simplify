package com.simplify.simplify

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.simplify.simplify.model.UserSettings
import com.simplify.simplify.model.userSettingDataStore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _userSettings = MutableStateFlow(UserSettings())
    val userSettings = _userSettings.asStateFlow()

    private val userSettingsDataStore: DataStore<UserSettings>
        get() = getApplication<Application>().applicationContext.userSettingDataStore

    init {

    }
}