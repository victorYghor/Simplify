package com.simplify.simplify

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.simplify.simplify.Destinations.LOGIN
import com.simplify.simplify.Destinations.PRESENTATION
import com.simplify.simplify.model.FirstStates
import com.simplify.simplify.ui.login.LoginScreen
import com.simplify.simplify.ui.presentation.PresentationScreen

object Destinations {
    const val PRESENTATION = "presentation"
    const val LOGIN = "login"
    const val SING_IN = "sing_in"
}
@Composable
fun SimplifyNavHost(
    navController: NavHostController = rememberNavController(),
    firstAccess: FirstStates
) {
    NavHost(
        navController = navController,
        startDestination = if (firstAccess == FirstStates.FIRST_ACCESS) {
            PRESENTATION
        } else {
            LOGIN
        }
    ) {
        composable(PRESENTATION) {
            PresentationScreen(
                onComplete = {
                    navController.navigate(LOGIN) {
                        launchSingleTop = true
                    }
                }
            )
        }
        Log.i("loading", "the value of firstAccess is $firstAccess")
        composable(LOGIN) {
            LoginScreen()
        }
    }
}