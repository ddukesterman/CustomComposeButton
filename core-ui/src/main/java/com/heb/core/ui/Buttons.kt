package com.heb.core.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val DEFAULT_TEXT_FONT_SIZE = 16.sp
private val DEFAULT_TEXT_PADDING = 8.dp
private val DEFAULT_BUTTON_ROUNDED_CORNER_RADIUS = 4.dp
private val DEFAULT_BUTTON_ELEVATION = 8.dp
private val DEFAULT_BUTTON_SHAPE = ButtonShape.ROUNDED_CORNER

/**
 * Common button used for basic UI
 *
 * @param modifier external modifier to be placed on the button
 * @param onClick Callback for clicking the button
 * @param text text for the
 */
@Composable
fun HebButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String,
    buttonConfig: ButtonConfig = ButtonConfig()
) {
    Button(
        enabled = buttonConfig.enabled,
        modifier = modifier,
        onClick = onClick,
        shape = when (buttonConfig.buttonShape) {
            ButtonShape.SQUARE -> RectangleShape
            ButtonShape.ROUNDED_CORNER ->
                RoundedCornerShape(buttonConfig.buttonCornerModifier)

            ButtonShape.CIRCLE -> CircleShape
            ButtonShape.CUT_CORNER -> CutCornerShape(
                topStart = buttonConfig.buttonCornerModifier,
                bottomEnd = buttonConfig.buttonCornerModifier,
            )
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = if (buttonConfig.buttonColor == Color.Unspecified)
                MaterialTheme.colorScheme.primary
            else
                buttonConfig.buttonColor,
            contentColor = if (buttonConfig.buttonColor == Color.Unspecified)
                MaterialTheme.colorScheme.onPrimary
            else
                buttonConfig.textColor,

            ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = DEFAULT_BUTTON_ELEVATION
        ),
    ) {
        Text(
            modifier = Modifier.padding(buttonConfig.textPadding),
            text = text,
            style = TextStyle.Default.copy(
                fontSize = buttonConfig.textSize,
                fontWeight = if (buttonConfig.useBoldText)
                    FontWeight.Bold
                else
                    FontWeight.Normal
            ),
        )
    }
}

/**
 * Configuration used for [HebButton] class.
 *
 * @param textSize Text size for the [Text] within the button
 * @param textColor Color used for the color of the text within the button
 * @param textPadding Padding used on the text's modifier within the button
 * @param buttonShape enum class [ButtonShape] to determine the shape of the button
 * @param buttonCornerModifier Value used for corner radius and cut depth
 */
data class ButtonConfig(
    val textSize: TextUnit = DEFAULT_TEXT_FONT_SIZE,
    val useBoldText: Boolean = false,
    val textPadding: Dp = DEFAULT_TEXT_PADDING,
    val buttonShape: ButtonShape = DEFAULT_BUTTON_SHAPE,
    val buttonCornerModifier: Dp = DEFAULT_BUTTON_ROUNDED_CORNER_RADIUS,
    val buttonColor: Color = Color.Unspecified,
    val textColor: Color = Color.Unspecified,
    val disabledButtonColor: Color = Color.Unspecified,
    val disabledTextColor: Color = Color.Unspecified,
    val enabled: Boolean = true,
)

/**
 * Used to determine which shape the button to appear as
 */
enum class ButtonShape {
    SQUARE,
    ROUNDED_CORNER,
    CIRCLE,
    CUT_CORNER,
}


@Preview
@Composable
fun HebButtonPreview() {
    HebButton(onClick = {}, text = "Preview Button")
}

@Preview
@Composable
fun HebButtonColorChangedPreview() {
    HebButton(
        onClick = {},
        text = "Preview Button",
        buttonConfig = ButtonConfig(buttonColor = Color(0xFFEE2824))
    )
}