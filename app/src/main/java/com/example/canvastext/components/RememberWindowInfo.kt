package com.example.canvastext.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun rememberWindowInfo():WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        // check the height and width in android documentations
        screenWidthInfo = when{
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 850 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Extended
        },
        screenHeightInfo = when{
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenHeightDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Extended
        },
        screenHeightDp = configuration.screenHeightDp,
        screenWidthDp = configuration.screenWidthDp,

        heightRatio = configuration.screenHeightDp / 659.0 ,
        widthRatio = configuration.screenWidthDp /  411.0 ,
    )
}

data class WindowInfo(
    val screenWidthInfo : WindowType,
    val screenHeightInfo : WindowType,
    val screenWidthDp : Int,
    val screenHeightDp : Int,
    val heightRatio : Double,
    val widthRatio : Double,
) {
    sealed class WindowType(){
        object Compact: WindowType()
        object Medium : WindowType()
        object Extended: WindowType()
    }
}