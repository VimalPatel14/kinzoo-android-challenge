package com.vimal.kinzooandroidchallenge.presentation.comman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.vimal.kinzooandroidchallenge.R
import com.vimal.kinzooandroidchallenge.ui.theme.LOTTIE_ANIMATION_SIZE
import com.vimal.kinzooandroidchallenge.ui.theme.SMALL_PADDING

@Composable
fun ErrorScreen(
    modifier: Modifier = Modifier,
    onRetryClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(SMALL_PADDING),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.network_error))

        LottieAnimation(
            modifier = Modifier.height(LOTTIE_ANIMATION_SIZE),
            composition = composition
        )

        Button(onClick = onRetryClick) {
            Text(
                text = stringResource(R.string.retry).toUpperCase(locale = Locale.current),
            )
        }
    }
}