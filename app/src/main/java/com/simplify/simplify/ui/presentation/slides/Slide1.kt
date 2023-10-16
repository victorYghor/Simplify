package com.simplify.simplify.ui.presentation.slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SimplifyText
import com.simplify.simplify.ui.theme.Blue800
import com.simplify.simplify.ui.theme.simplifyTypography

// todo make this a responsive layout
@Composable
fun Slide1(innerPadding: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp).fillMaxSize().padding(innerPadding),
        verticalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        SimplifyText(R.string.welcome_msg, style = simplifyTypography.titleMedium)
        Image(
            painterResource(R.drawable.symplify),
            contentDescription = stringResource(R.string.simplify_logo)
        )
        SimplifyText(R.string.app_name, simplifyTypography.titleMedium)
        SimplifyText(R.string.here_you_can_stay_up, style = simplifyTypography.bodyMedium)
        Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,  modifier = Modifier.fillMaxWidth()) {
            Icon(
                painterResource(R.drawable.notification_active),
                contentDescription = null,
                modifier = Modifier.size(64.dp),
                tint = Blue800
            )
            Spacer(modifier = Modifier.size(4.dp))
            SimplifyText(R.string.always_be_notified, style = simplifyTypography.bodySmall)
        }
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(),
        ) {
            Icon(painterResource(R.drawable.settings), contentDescription = null, tint = Blue800)
            Spacer(modifier = Modifier.size(4.dp))
            SimplifyText(R.string.custom_notifications, style = simplifyTypography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Slide1Preview(

) {
    Slide1(PaddingValues())
}