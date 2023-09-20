package com.example.canvastext.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIconDefaults.Text
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.canvastext.ui.theme.heavyTeal
import com.example.canvastext.ui.theme.lightGray
import com.example.canvastext.ui.theme.orange
import com.example.canvastext.util.ButtonType

@Composable
fun ShadowedButtonGrid(
    modifier: Modifier = Modifier,
    verticalButtonSpacing: Dp = 20.dp,
    horizontalButtonSpacing: Dp = 20.dp,
    windowInfo:WindowInfo
) {
    Column(
        modifier = modifier
            .padding(verticalButtonSpacing),
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(
                horizontalButtonSpacing,
                Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    verticalButtonSpacing,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = heavyTeal,
                    text = "AC",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = heavyTeal,
                    text = "C",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = heavyTeal,
                    text = "%",
                    onClicked = {}
                )
                ShadowedButton(
                    color = orange,
                    windowInfo = windowInfo,
                    text = "÷",
                    onClicked = {}
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    verticalButtonSpacing,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "7",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "8",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "9",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = orange,
                    text = "x",
                    onClicked = {}
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    verticalButtonSpacing,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "4",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "5",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "6",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = orange,
                    text = "-",
                    onClicked = {}
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    verticalButtonSpacing,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "1",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "2",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = "3",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = orange,
                    text = "+",
                    onClicked = {}
                )
            }
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(
                    verticalButtonSpacing,
                    alignment = Alignment.CenterHorizontally
                )
            ) {
                ShadowedButton(
                    windowInfo = windowInfo,
                    type = ButtonType.RectangleType,
                    text = "0",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    text = ".",
                    onClicked = {}
                )
                ShadowedButton(
                    windowInfo = windowInfo,
                    color = orange,
                    text = "=",
                    onClicked = {}
                )
            }
        }
    }
}