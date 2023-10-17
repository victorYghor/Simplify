package com.simplify.simplify.ui.login

import androidx.annotation.StringRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.components.ContinueWithButtons
import com.simplify.simplify.ui.theme.FaceBlue
import com.simplify.simplify.ui.theme.GithubDark
import com.simplify.simplify.ui.theme.Gray0
import com.simplify.simplify.ui.theme.Gray50
import com.simplify.simplify.ui.theme.Gray900
import com.simplify.simplify.ui.theme.LinkedinBlue
import com.simplify.simplify.ui.theme.simplifyTypography

@Composable
fun SingIn() {
    Column(
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(text = stringResource(R.string.enter), style = simplifyTypography.titleLarge)
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            ContinueWithButtons(
                text = "${stringResource(R.string.contunie_with)}  ${stringResource(R.string.google)}",
                icon = R.drawable.google,
                modifier = Modifier,
                textColor = Gray900,
                backgroundColor = Gray50,
                border = BorderStroke(1.dp, Color.Black),
                onClick = {

                }
            )
            ContinueWithButtons(
                text = "${stringResource(R.string.contunie_with)} ${stringResource(R.string.facebook)}",
                icon = R.drawable.facebook,
                textColor = Gray50,
                backgroundColor = FaceBlue,
                border = null,
                modifier = Modifier,
                onClick =  {

                }
            )
            ContinueWithButtons(
                text = "${stringResource(R.string.contunie_with)} ${stringResource(R.string.git_hub)}",
                icon = R.drawable.github_mark_white,
                textColor = Gray50,
                backgroundColor = GithubDark,
                border = null,
                modifier = Modifier,
                onClick = {

                }
            )
            ContinueWithButtons(
                text = "${stringResource(R.string.contunie_with)}  ${stringResource(R.string.linkedin)}",
                onClick = {

                },
                icon = R.drawable.linkedin,
                modifier = Modifier,
                textColor = Gray0,
                backgroundColor = LinkedinBlue,
                border = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SingInPreview() {
    SingIn()
}