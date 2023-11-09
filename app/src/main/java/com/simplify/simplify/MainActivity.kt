package com.simplify.simplify

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.simplify.simplify.ui.theme.SimplifyTheme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "info")
    val FIRST_ACESS = booleanPreferencesKey("first_acess")
    val scope = this.lifecycleScope

    var firstAccess: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        scope.launch {
            firstAccess = dataStore.data.map { info ->
                info[FIRST_ACESS] ?: true
            }.first()
        }
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        val currentUser = auth.currentUser
        if(currentUser != null) {

        }
        setContent {
            SimplifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = firstAccess!!)
                }
            }
        }
        scope.launch {
            dataStore.edit { info ->
                info[FIRST_ACESS] = false
            }
        }
    }
}
