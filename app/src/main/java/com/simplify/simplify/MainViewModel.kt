package com.simplify.simplify

import androidx.datastore.core.DataStore
import androidx.lifecycle.ViewModel
import com.simplify.simplify.model.UserSettings

class MainViewModel(dataStore: DataStore<UserSettings>) : ViewModel()