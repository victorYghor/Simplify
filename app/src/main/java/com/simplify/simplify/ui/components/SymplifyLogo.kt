package com.simplify.simplify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.theme.simplifyTypography
import androidx.compose.ui.Alignment
@Composable
fun SymplifyLogo() {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource(R.drawable.symplify),
            contentDescription = stringResource(R.string.simplify_logo)
        )
        SimplifyText(R.string.app_name, simplifyTypography.titleMedium)
    }

}