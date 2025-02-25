package com.vimal.kinzooandroidchallenge.presentation.comman

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vimal.kinzooandroidchallenge.ui.theme.LARGE_PADDING
import com.vimal.kinzooandroidchallenge.ui.theme.MEDIUM_PADDING
import com.vimal.kinzooandroidchallenge.ui.theme.SMALL_PADDING
import com.vimal.kinzooandroidchallenge.ui.theme.Shapes
import com.vimal.kinzooandroidchallenge.ui.theme.shimmerEffectColor
import com.vimal.kinzooandroidchallenge.util.calculateAlphaInfiniteAnimation

@Composable
fun AnimatedEpisodeShimmerEffect() {
    val alphaAnim = calculateAlphaInfiniteAnimation()

    EpisodeItemShimmerEffectContent(alpha = alphaAnim)
}

@Composable
fun EpisodeItemShimmerEffectContent(
    alpha: Float
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = LARGE_PADDING)
            .height(80.dp),
        color = Color.White,
        shape = Shapes.medium
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .padding(MEDIUM_PADDING)
                    .weight(0.4f),
                verticalArrangement = Arrangement.Bottom
            ) {
                Surface(
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .fillMaxWidth(0.5f)
                        .height(10.dp),
                    color = MaterialTheme.colors.shimmerEffectColor,
                    shape = Shapes.medium
                ) {}
                Spacer(modifier = Modifier.padding(SMALL_PADDING))
                Surface(
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .fillMaxWidth(0.3f)
                        .height(15.dp),
                    color = MaterialTheme.colors.shimmerEffectColor,
                    shape = Shapes.medium
                ) {}
                Spacer(modifier = Modifier.padding(SMALL_PADDING))
                Surface(
                    modifier = Modifier
                        .alpha(alpha = alpha)
                        .fillMaxWidth(0.7f)
                        .height(15.dp),
                    color = MaterialTheme.colors.shimmerEffectColor,
                    shape = Shapes.medium
                ) {}
            }

            Surface(
                modifier = Modifier
                    .alpha(alpha = alpha)
                    .size(28.dp)
                    .clip(CircleShape),
                color = MaterialTheme.colors.shimmerEffectColor
            ) {

            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShimmerEffectPreview() {
    EpisodeItemShimmerEffectContent(alpha = 0.4f)
}