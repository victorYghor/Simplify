package com.simplify.simplify

import android.annotation.SuppressLint
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.simplify.simplify.ui.theme.SimplifyTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
    val viewModel: MainViewModel by viewModels()
    val scope = this.lifecycleScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.collectFirstAccess()
        installSplashScreen().setKeepOnScreenCondition(condition = {
            viewModel.mainState.value.keepSplash
        })

        setContent {
            SimplifyTheme {
                val firstAccess = viewModel.mainState.collectAsStateWithLifecycle()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    supportActionBar?.hide()
                    SimplifyNavHost(firstAccess = firstAccess.value.isFirstAccess)
                }
            }
        }
    }

    override fun onStop() {
        scope.launch(Dispatchers.IO) {
            viewModel.registerFirstAccess()
        }
        super.onStop()
    }


}
