package com.example.canvastext.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.PathNode
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorTopScreen(
    modifier: Modifier = Modifier,
    padding: Dp = 10.dp,
    operation: String = "",
    result: String = ""
) {
    val infiniteTransition = rememberInfiniteTransition()
    val color by infiniteTransition.animateColor(
        initialValue = Color.DarkGray,
        targetValue = Color.LightGray,
        animationSpec = infiniteRepeatable(
            animation = tween(2000,
                easing = LinearEasing
            ) ,
            repeatMode = RepeatMode.Reverse,
        )
    )
    Box(modifier = Modifier) {
        Column(modifier = Modifier.align(Alignment.TopStart)) {
            Text(
                modifier = Modifier.offset(y = (-10).dp, x = 30.dp),
                text = "YAZIO",
                style = MaterialTheme.typography.h2
            )
            Text(
                modifier = Modifier.offset(y = (-35).dp, x = 30.dp),
                text = "Calculator",
                style = MaterialTheme.typography.subtitle2
            )
        }
        Column(modifier = modifier.padding(start = padding, end = padding, bottom = 25.dp)) {
            Row(
                modifier = Modifier
                    .padding(top = 20.dp, bottom = 20.dp)
                    .align(Alignment.End),
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                for (i in 1..4) {
                    ShadowedSquare()
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .border(width = 10.dp, color = color , shape = CutCornerShape(topStart = 60.dp))
                    .drawBehind {
                        drawRect(
                            color = Color.Black,
                            topLeft = Offset(x = 35.dp.toPx(), y = 35.dp.toPx()),
                            size = size.copy(
                                width = size.width - 30.dp.toPx(),
                                height = size.height - 30.dp.toPx()
                            ),
                        )
                    }
                    .clip(shape = CutCornerShape(topStart = 60.dp))
                    .background(Color.White)

            ) {
                Column(modifier = Modifier.matchParentSize()) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp, start = 30.dp, end = 15.dp),
                        text = operation,
                        style = MaterialTheme.typography.h3,
                        textAlign = TextAlign.End,
                        maxLines = 1,
                        letterSpacing = 3.sp,
                        overflow = TextOverflow.Clip
                    )
                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-29).dp)
                            .padding(bottom = 30.dp, start = 30.dp, end = 15.dp),
                        text = result,
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.End,
                        maxLines = 1,
                        letterSpacing = 2.sp,
                        overflow = TextOverflow.Clip
                    )
                }
            }
        }
    }
}