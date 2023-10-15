package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText
import com.simplify.simplify.ui.theme.typography

@Composable
fun Slide1(innerPadding: Dp) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(innerPadding).fillMaxSize()) {
        SimplifyText(R.string.welcome_msg, style = typography.titleMedium)
        Image(
            painterResource(R.drawable.symplify),
            contentDescription = stringResource(R.string.simplify_logo)
        )
        SimplifyText(R.string.app_name, typography.titleMedium)
        SimplifyText(R.string.here_you_can_stay_up, style = typography.bodyMedium)
        Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically,  modifier = Modifier.fillMaxWidth()) {
            Icon(painterResource(R.drawable.round_notifications_active_24), contentDescription = null, modifier = Modifier.size(64.dp))
            SimplifyText(R.string.always_be_notified, style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly, verticalAlignment = Alignment.CenterVertically,  modifier = Modifier.fillMaxWidth()) {
            Icon(painterResource(R.drawable.settings), contentDescription = null)
            SimplifyText(R.string.custom_notifications, style = typography.bodyMedium.copy(fontWeight = FontWeight.Bold))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Slide1Preview(

) {
    Slide1(4.dp)
}