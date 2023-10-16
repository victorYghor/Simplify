package com.simplify.simplify.ui.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
    goToNextSlide: () -> Unit,
    slideNumber: Int,
    updateSlide: (Int) -> Unit
) {

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Spacer(modifier = Modifier)
        CirclesNavButtons(presentationNumber = slideNumber, modifier = Modifier.size(width = 250.dp, height = 90.dp), updateSlide = updateSlide)
        IconButton(onClick = { goToNextSlide() }, modifier = Modifier.size(72.dp)) {
            Icon(
                painterResource(R.drawable.right_arrow),
                contentDescription = stringResource(R.string.btn_go_to_next_slides),
                modifier = Modifier.size(72.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BottomAppBarDefaultsPreview() {
    BottomBarSlide( { }, 1, updateSlide = {})
}
@Composable
fun CirclesNavButtons(presentationNumber: Int, modifier: Modifier, updateSlide: (Int) -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle_on),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable { updateSlide(1) }
        )
        Image(
            painter = painterResource(id = if(presentationNumber > 1) R.drawable.circle_on else R.drawable.circle_off),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable { updateSlide(2)  }
        )
        Image(
            painter = painterResource(id = if(presentationNumber > 2) R.drawable.circle_on else R.drawable.circle_off),
            contentDescription = null,
            modifier = Modifier.size(50.dp).clickable { updateSlide(3) }
        )
    }
}