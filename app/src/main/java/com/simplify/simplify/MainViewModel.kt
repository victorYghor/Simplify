package com.simplify.simplify

import android.app.Application
import androidx.datastore.core.DataStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.simplify.simplify.model.UserSettings
import com.simplify.simplify.model.userSettingDataStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class MainUiState(
    val keepSplash: Boolean = true,
    val isFirstAccess: Boolean = true
)
class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val _mainState = MutableStateFlow(MainUiState())
    val mainState = _mainState.asStateFlow()

    private val userSettingsDataStore: DataStore<UserSettings>
        get() = getApplication<Application>().applicationContext.userSettingDataStore

    /**
     * collect the value of data store if is first access
     */
    fun collectFirstAccess() {
        viewModelScope.launch(Dispatchers.IO) {
            userSettingsDataStore.data.collectLatest { userSettings ->
                _mainState.update {
                    it.copy(
                        isFirstAccess = userSettings.isFirstAccess,
                        keepSplash = false
                    )
                }
            }
        }
    }

    suspend fun registerFirstAccess() {
        viewModelScope.launch(Dispatchers.IO) {
            userSettingsDataStore.updateData {
                it.copy(isFirstAccess = false)
            }
        }
    }

}