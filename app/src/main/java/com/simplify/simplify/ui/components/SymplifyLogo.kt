package com.simplify.simplify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.theme.simplifyTypography
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.simplify.simplify.ui.theme.Gray50
import com.simplify.simplify.ui.theme.Gray900

@Composable
fun SymplifyLogo() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
        Image(
            painterResource(R.drawable.symplify),
            contentDescription = stringResource(R.string.simplify_logo)
        )
        SimplifyText(R.string.app_name, simplifyTypography.titleMedium.copy(fontWeight = FontWeight(300)), color = Gray900)
    }

}