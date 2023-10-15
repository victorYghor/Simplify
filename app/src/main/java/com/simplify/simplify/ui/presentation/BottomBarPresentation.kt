package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R

@Composable
fun BottomBarSlide(
    goToNextSlide: () -> Unit
) {
    val slideNumber by remember { mutableStateOf(1) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier)
        CirclesNavButtons(presentationNumber = slideNumber, modifier = Modifier.size(width = 250.dp, height = 50.dp))
        IconButton(onClick = { goToNextSlide() }) {
            Icon(
                painter = painterResource(id = R.drawable.right_arrow),
                contentDescription = stringResource(
                    R.string.btn_go_to_next_slides
                ),
                modifier = Modifier.size(64.dp)
            )
        }
    }
}

@Composable
fun CirclesNavButtons(
    presentationNumber: Int,
    modifier: Modifier
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        when (presentationNumber) {
            1 -> {
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_off),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_off),
                    contentDescription = null
                )
            }

            2 -> {
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_off),
                    contentDescription = null
                )
            }

            3 -> {
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
                Icon(
                    painter = painterResource(id = R.drawable.circle_on),
                    contentDescription = null
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun BottomAppBarDefaultsPreview() {
    BottomBarSlide {

    }
}