package com.simplify.simplify

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.datastore.dataStore
import com.simplify.simplify.model.UserSettingsSerializer
import com.simplify.simplify.ui.theme.SimplifyTheme


class MainActivity : AppCompatActivity() {
    val Context.dataStore by dataStore("user-setting.json", UserSettingsSerializer)
    val viewModel = MainViewModel(dataStore)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            SimplifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = true)
                }
            }
        }
    }
}
