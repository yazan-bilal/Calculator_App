package com.example.canvastext.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun ShadowedSquare(
    modifier: Modifier = Modifier,
    squareSize: Dp = 20.dp
) {
    Box(
        modifier = Modifier.size(squareSize)
            .drawBehind {
                drawRoundRect(
                    color = Color.Black,
                    size = size,
                    style = Stroke(
                        width = 3.dp.toPx(),
                    ),
                    cornerRadius = CornerRadius(2.dp.toPx())
                )
                drawRoundRect(
                    topLeft = Offset(3.dp.toPx(), 4.dp.toPx()),
                    color = Color.Black,
                    size = size,
                    cornerRadius = CornerRadius(2.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(2.dp))
            .background(Color.White)
            .then(modifier)
    )
}