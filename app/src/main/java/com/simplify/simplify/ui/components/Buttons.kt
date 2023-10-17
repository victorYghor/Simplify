package com.simplify.simplify.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ButtonDefaults.filledTonalButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.theme.Blue800
import com.simplify.simplify.ui.theme.LinkedinBlue
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
    text: String,
    onClick: () -> Unit,
    modifier: Modifier,
    icon: Int,
    textColor: Color,
    backgroundColor: Color,
    border: BorderStroke?
) {
    Button(
        onClick = { onClick() },
        modifier = modifier.fillMaxWidth(0.9f),
        colors = buttonColors(containerColor = backgroundColor, contentColor = textColor),
        border = border
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Image(
                painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(48.dp)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                text,
                style = simplifyTypography.bodySmall,
                color = textColor
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun SymplifyButtonPreview() {
    ContinueWithButtons(
        "Enter",
        modifier = Modifier,
        onClick = {},
        icon = R.drawable.linkedin,
        backgroundColor = LinkedinBlue,
        textColor = Color.White,
        border = null
    )
}

