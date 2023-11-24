package com.simplify.simplify

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.simplify.simplify.model.IsFirstAccess
import com.simplify.simplify.ui.theme.SimplifyTheme
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel = MainViewModel(application)
        installSplashScreen().setKeepOnScreenCondition(condition = {
            (viewModel.userSettings.value.isFirstAccess == IsFirstAccess.LOADING) || (viewModel.isUserAccess?.isCompleted
                ?: false).not()
        })
        val isFirstAccess = viewModel.userSettings.value.isFirstAccess
        setContent {
            SimplifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = isFirstAccess)
                }
            }
        }
    }

    override fun onDestroy() {
        val viewModel: MainViewModel by viewModels<MainViewModel>()
        runBlocking {
            viewModel.endFirstTime()
        }
        super.onDestroy()
    }
}
