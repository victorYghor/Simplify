package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.simplify.simplify.R
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomBarSlide(
    slideNumber: Int,
    slideState: PagerState
) {

    val scope = rememberCoroutineScope()

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier)
        CirclesNavButtons(
            slideNumber = slideNumber,
            modifier = Modifier.size(width = 250.dp, height = 90.dp),
            slideState = slideState
        )
        IconButton(onClick = {
            scope.launch {
                slideState.animateScrollToPage(slideNumber + 1)
            }
        }, modifier = Modifier.size(72.dp)) {
            Icon(
                painterResource(R.drawable.right_arrow),
                contentDescription = stringResource(R.string.btn_go_to_next_slides),
                modifier = Modifier.size(72.dp)
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