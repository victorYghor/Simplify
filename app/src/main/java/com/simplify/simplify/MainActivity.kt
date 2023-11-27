package com.simplify.simplify

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import com.simplify.simplify.model.FirstStates
import com.simplify.simplify.ui.theme.SimplifyTheme
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    val scope = this.lifecycleScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition(condition = {
            viewModel.userSettings.value.isFirstAccess == FirstStates.LOADING
        })



        setContent {
            SimplifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val firstAccess by remember { mutableStateOf(viewModel.userSettings.value.isFirstAccess) }
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = firstAccess)
                }
            }
        }
    }

    override fun onStop() {
        scope.launch {
            viewModel.endFirstTime()
        }
        super.onStop()
    }

}
