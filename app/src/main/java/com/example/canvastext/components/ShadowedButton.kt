package com.example.canvastext.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.unit.dp
import com.example.canvastext.util.ButtonType

@Composable
fun ShadowedButton(
    modifier: Modifier = Modifier,
    text: String = "",
    onClicked: () -> Unit,
    type:ButtonType = ButtonType.SquareType,
    color:Color = Color.Black,
    windowInfo: WindowInfo
) {
    val heightRatio = windowInfo.heightRatio
    val widthRatio = windowInfo.widthRatio
    val width  = if(type is ButtonType.SquareType) {
        (75* widthRatio).dp
    }else {
        (170 * widthRatio).dp
    }
    val height = (50 * heightRatio).dp
    Box(
        modifier = Modifier
            .width(width)
            .height(height)
            .drawBehind {
                drawRoundRect(
                    color = Color.Black,
                    size = size,
                    style = Stroke(
                        width = 5.dp.toPx(),
                    ),
                    cornerRadius = CornerRadius(2.dp.toPx())
                )
                drawRoundRect(
                    topLeft = Offset(5.dp.toPx(), 6.dp.toPx()),
                    color = Color.Black,
                    size = size,
                    cornerRadius = CornerRadius(5.dp.toPx())
                )
            }
            .clip(RoundedCornerShape(2.dp))
            .background(Color.White)
            .clickable(onClick = onClicked)
            .then(modifier)
        , contentAlignment = Alignment.Center

    ) {
        Text(
            text = text,
            color = color,
            style = MaterialTheme.typography.h3,
        )
    }
}
