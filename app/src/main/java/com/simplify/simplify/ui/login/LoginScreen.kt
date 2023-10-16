package com.simplify.simplify.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.ContinueWithButtons
import com.simplify.simplify.ui.components.SymplifyButtons
import com.simplify.simplify.ui.components.SymplifyLogo

@Composable
fun LoginScreen() {
    Column(verticalArrangement = Arrangement.SpaceAround, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxSize()) {
        SymplifyLogo()
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ContinueWithButtons(
               textRes = R.string.linkedin,
                onClick = { },
                icon = R.drawable.linkedin,
                modifier = Modifier
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}