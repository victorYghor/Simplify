package com.simplify.simplify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonDefaults.filledTonalButtonColors
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.theme.Black
import com.simplify.simplify.ui.theme.Blue800
import com.simplify.simplify.ui.theme.simplifyTypography

@Composable
fun SymplifyButtons(
    textRes: Int,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = { onClick() },
        colors = filledTonalButtonColors(containerColor = Blue800, contentColor = Color.White),
        modifier = modifier.size(width = 320.dp, height = 72.dp)
    ) {
        SimplifyText(textRes, simplifyTypography.titleSmall)
    }
}

@Composable
fun ContinueWithButtons(
    textRes: Int,
    onClick: () -> Unit,
    modifier: Modifier,
    icon: Int,
    textColor: Color,
    backgroundColor: Color
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth(0.9f),
        colors = ButtonColors(backgroundColor = backgroundColor)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(16.dp).fillMaxWidth()
        ) {
            Image(
                painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(64.dp)
            )
            SimplifyText(
                textRes,
                simplifyTypography.titleSmall,
                color = textColor
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SymplifyButtonPreview() {
    ContinueWithButtons(
        R.string.enter,
        modifier = Modifier,
        onClick = {},
        icon = R.drawable.linkedin
    )
}

