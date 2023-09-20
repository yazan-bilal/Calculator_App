package com.example.canvastext.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.canvastext.ui.theme.heavyTeal
import com.example.canvastext.ui.theme.lightGray
import com.example.canvastext.ui.theme.orange
import com.example.canvastext.util.ButtonType
import com.example.canvastext.view_model.CalculatorViewModel

@Composable
fun CalculatorFullScreen(
    modifier: Modifier = Modifier,
    calculatorViewModel : CalculatorViewModel = viewModel()
){
    val operationState = calculatorViewModel.operation
    val resultState = calculatorViewModel.result
    val windowInfo = rememberWindowInfo()
    val verticalButtonSpacing: Dp =( 20*windowInfo.widthRatio).dp
    val horizontalButtonSpacing: Dp =( 20*windowInfo.heightRatio).dp
    Column(modifier = modifier
        .fillMaxSize()
        .background(lightGray)) {
        CalculatorTopScreen(
            operation = operationState.value,
            result = resultState.value
        )

        Column(
            modifier = Modifier
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
                        onClicked = {calculatorViewModel.delete()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = heavyTeal,
                        text = "C",
                        onClicked = {calculatorViewModel.deleteLast()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = heavyTeal,
                        text = "%",
                        onClicked = {calculatorViewModel.mod()}
                    )
                    ShadowedButton(
                        color = orange,
                        windowInfo = windowInfo,
                        text = "÷",
                        onClicked = {calculatorViewModel.divide()}
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
                        onClicked = {calculatorViewModel.seven()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "8",
                        onClicked = {calculatorViewModel.eight()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "9",
                        onClicked = {calculatorViewModel.nine()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = orange,
                        text = "x",
                        onClicked = {calculatorViewModel.multi()}
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
                        onClicked = {calculatorViewModel.four()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "5",
                        onClicked = {calculatorViewModel.five()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "6",
                        onClicked = {calculatorViewModel.six()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = orange,
                        text = "-",
                        onClicked = {calculatorViewModel.minus()}
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
                        onClicked = {calculatorViewModel.one()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "2",
                        onClicked = {calculatorViewModel.two()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = "3",
                        onClicked = {calculatorViewModel.three()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = orange,
                        text = "+",
                        onClicked = {calculatorViewModel.add()}
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
                        onClicked = {calculatorViewModel.zero()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        text = ".",
                        onClicked = {calculatorViewModel.dot()}
                    )
                    ShadowedButton(
                        windowInfo = windowInfo,
                        color = orange,
                        text = "=",
                        onClicked = {calculatorViewModel.result()}
                    )
                }
            }
        }

    }
}