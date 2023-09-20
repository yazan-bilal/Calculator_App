package com.example.canvastext.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.canvastext.R

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )

    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)

private val Bungee = FontFamily(
    Font(R.font.bungee),
)

val RetroTypography = Typography(
    h1 = TextStyle(
        fontFamily = Bungee,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = Bungee,
        fontSize = 24.sp
    ),
    h3 = TextStyle(
        fontFamily = Bungee,
        fontSize = 20.sp
    ),
    h4 = TextStyle(
        fontFamily = Bungee,
        fontSize = 18.sp
    ),
    h5 = TextStyle(
        fontFamily = Bungee,
        fontSize = 16.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = Bungee,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = Bungee,
        fontSize = 12.sp,
        color = Color.Gray
    )


)