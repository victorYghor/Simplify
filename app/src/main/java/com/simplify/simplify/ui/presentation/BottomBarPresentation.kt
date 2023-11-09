package com.simplify.simplify.ui.presentation

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import com.simplify.simplify.ui.theme.Blue800
import com.simplify.simplify.ui.theme.simplifyTypography
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarSlide(
    slideNumber: Int,
    slideState: PagerState,
    onComplete: () -> Unit
) {

    val scope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {

        CirclesNavButtons(
            slideNumber = slideNumber,
            modifier = Modifier.size(width = 170.dp, height = 90.dp),
            slideState = slideState
        )
        Button(
            onClick = {
                Log.i("BottomBar", "on click")
                scope.launch {
                    Log.i("BottomBar", "reach coroutine")
                    when(slideNumber) {
                        0 -> slideState.scrollToPage(1)
                        1 -> slideState.scrollToPage(2)
                        2 -> onComplete()
                    }
                }
            },
            colors = buttonColors(containerColor = Blue800, contentColor = Color.White),
            modifier = Modifier) {
            Text(
                text = stringResource(if (slideNumber < 2) R.string.next else R.string.start),
                style = simplifyTypography.bodySmall
            )
            Icon(
                painter = painterResource(R.drawable.right_arrow),
                contentDescription = null,
                modifier = Modifier.size(50.dp)
            )
        }
    }
}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CirclesNavButtons(slideNumber: Int, modifier: Modifier, slideState: PagerState) {
    val scope = rememberCoroutineScope()
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle_on),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable {
                scope.launch {
                    slideState.animateScrollToPage(0)
                }
            }
        )
        Image(
            painter = painterResource(id = if (slideNumber > 0) R.drawable.circle_on else R.drawable.circle_off),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable {
                scope.launch {
                    slideState.animateScrollToPage(1)
                }
            }
        )
        Image(
            painter = painterResource(id = if (slideNumber > 1) R.drawable.circle_on else R.drawable.circle_off),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable {
                scope.launch {
                    slideState.animateScrollToPage(2)
                }
            }
        )
    }
}