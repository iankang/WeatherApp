package com.dvt.weatherapp.ui.common

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun lottieAnimation(
    resource:Int,
    size: Dp
){
    val composition by rememberLottieComposition(
        LottieCompositionSpec
            .RawRes(resource)
    )
    LottieAnimation(
        composition =composition,
        modifier = Modifier.size(size)
    )
}