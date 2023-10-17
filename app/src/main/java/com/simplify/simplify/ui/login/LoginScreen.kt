package com.simplify.simplify.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.ContinueWithButtons
import com.simplify.simplify.ui.components.SymplifyLogo
import com.simplify.simplify.ui.theme.Gray0
import com.simplify.simplify.ui.theme.Gray50
import com.simplify.simplify.ui.theme.Gray900
import com.simplify.simplify.ui.theme.LinkedinBlue

@Composable
fun LoginScreen() {
    Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        SymplifyLogo()

    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}