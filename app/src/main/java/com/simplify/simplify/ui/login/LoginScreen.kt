package com.simplify.simplify.ui.login

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.SymplifyButtons
import com.simplify.simplify.ui.components.SymplifyLogo
import com.simplify.simplify.ui.theme.Blue800
import com.simplify.simplify.ui.theme.clickableText
import com.simplify.simplify.ui.theme.simplifyTypography

@Composable
fun LoginScreen() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        val context = LocalContext.current

        SymplifyLogo()
        SymplifyButtons(
            textRes = R.string.enter,
            modifier = Modifier,
            onClick = {

            },
        )
        val termsAndPolicy = buildAnnotatedString {
            append(stringResource(R.string.continue_you_agree) + " ")

            pushStringAnnotation(tag = "terms", annotation = "https://google.com/terms")
            withStyle(style = SpanStyle(color = clickableText)) {
                append(stringResource(R.string.service_terms) + " ")
            }
            pop()

            append(stringResource(R.string.we_use_personal_info))

            pushStringAnnotation(tag = "policy", annotation = "https://google.com/policy")
            withStyle(style = SpanStyle(color = clickableText)) {
                append(" " + stringResource(R.string.privacy_policy))
            }
            pop()
        }

        ClickableText(
            text = termsAndPolicy,
            style = simplifyTypography.bodySmall,
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            onClick = { offset ->
                termsAndPolicy.getStringAnnotations(
                    tag = "terms",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                    Log.i("terms URL", it.item)
                    Toast.makeText(context, "you click in the terms", Toast.LENGTH_LONG).show()
                }

                termsAndPolicy.getStringAnnotations(
                    tag = "policy",
                    start = offset,
                    end = offset
                ).firstOrNull()?.let {
                    Log.i("policy", it.item)
                    Toast.makeText(context, "you click in the policy", Toast.LENGTH_LONG).show()
                }
            }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}