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
import androidx.lifecycle.lifecycleScope
import com.simplify.simplify.model.FirstStates
import com.simplify.simplify.ui.theme.SimplifyTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    val scope = this.lifecycleScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var isFirstAccess: FirstStates? = null
        scope.launch {
            isFirstAccess = viewModel.retrieveDataStore()
        }
        installSplashScreen().setKeepOnScreenCondition(condition = {
            viewModel.dataStoreIsLoading.value
        })
        setContent {
            SimplifyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = isFirstAccess!!)
                }
            }
        }
    }

    override fun onDestroy() {
        viewModel.endFirstTime()
        super.onDestroy()
    }
}
