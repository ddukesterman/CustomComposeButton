# Custom Button Component for Android Compose

## Overview

This document provides a comprehensive guide to implement a resuable and customizable button component for Android Jetpack Compose. The button supports various customizable options that allow the developer fit their application's needs.

## Features

- Customizable Text
    - Field `text` will modify the text that is visible in the button.
- Click Action
    - Use `onClick` function to handle click event for the button.
- Bold Text
    - Use `useBoldText` to either have the text bold or normal.
- Customizable Text Padding
    - Field `textPadding` will adjust the padding around the text within
- Customizable Shape
    - Field `buttonShape` will change the shape of the button. Use the enum `ButtonShape` to determine what shape the button will be.
        - `SQUARE`: Shape that has sharp corners like a square.
        - `ROUNDED_CORNER`: Shape that is like teh square, but a rounded corners that can be modified.
        - `CIRCLE`: This will provide a circle/oval shape.
        - `CUT_CORNER`: This will provide a button with cut corners in the top left and bottom right of the button shape.
    - Field `buttonCornerModifier` will determine the corner radius of a `ROUNDED_CORNER` shape and the depth of the cut in the `CUT_CORNER` shape.
- Customizable Colors
    - Field `buttonColor` will adjust the color of the button.
    - Field `textColor` will adjust the color of the text.
    - Field `disabledButtonColor` will adjust the color of the button when it is disabled.
    - Field `disabledTextColor` will adjust the color of the text when it is disabled.
- Enabled/Disabled State
    - Field `enabled` will either enable or disable the button from being used.

## API Details

### Top Level Button Properties

- **text: String**
    - **Description**: The text to be displayed on the button.
    - **Type**: `String`
    - **Default**: `Must be provided`
    - **Example**: `"Button Text"`

- **onClick: () -> Unit**
    - **Description**: The callback function to be invoked when the button is clicked.
    - **Type**: `() -> Unit`
    - **Default**: `Must be provided`
    - **Example**: `{ /* Handle click */ }`

- **buttonConfig: ButtonConfig**
    - **Description**: Configuration options for the button's appearance and behavior.
    - **Type**: `ButtonConfig`
    - **Default**: `ButtonConfig Defaults`

### ButtonConfig Properties

- **enabled: Boolean**
    - **Description**: Indicates whether the button is enabled or disabled.
    - **Type**: `Boolean`
    - **Default**: `true`
    - **Example**: `false`

- **textSize: TextUnit**
    - **Description**: The size of the text on the button.
    - **Type**: `TextUnit`
    - **Default**: `16.sp`
    - **Example**: `20.sp`

- **useBoldText: Boolean**
    - **Description**: Indicates whether the text should be bold.
    - **Type**: `Boolean`
    - **Default**: `false`
    - **Example**: `true`

- **textPadding: Dp**
    - **Description**: The padding around the text inside the button.
    - **Type**: `androidx.compose.ui.unit.Dp`
    - **Default**: `8.dp`
    - **Example**: `16.dp`

- **buttonShape: ButtonShape**
    - **Description**: The shape of the button. Can be `RECTANGLE`, `ROUNDED_CORNER`, or `CIRCLE`.
    - **Type**: `enum ButtonShape`
    - **Default**: `ButtonShape.ROUNDED_CORNER`
    - **Example**: `ButtonShape.RECTANGLE`

- **buttonCornerModifier: Dp**
    - **Description**: The corner radius for rounded corner shapes.
    - **Type**: `androidx.compose.ui.unit.Dp`
    - **Default**: `4.dp`
    - **Example**: `8.dp`

- **buttonColor: Color**
    - **Description**: The background color of the button.
    - **Type**: `androidx.compose.ui.graphics.Color`
    - **Default**: `Color.Unspecified`
    - **Example**: `Color.Red`

- **textColor: Color**
    - **Description**: The color of the text content on the button.
    - **Type**: `androidx.compose.ui.graphics.Color`
    - **Default**: `Color.Unspecified`
    - **Example**: `Color.Black`

- **disabledTextColor: Color**
    - **Description**: The color of the text when the button is disabled.
    - **Type**: `androidx.compose.ui.graphics.Color`
    - **Default**: `Color.Unspecified`
    - **Example**: `Color.LightGray`

- **disabledContainerColor: Color**
    - **Description**: The background color of the button when it is disabled.
    - **Type**: `androidx.compose.ui.graphics.Color`
    - **Default**: `Color.Unspecified`
    - **Example**: `Color.DarkGray`

### Usage Example

```` kotlin
HebButton(
    onClick = { 
        // Handle click logic here
    },
    text = "Button Text",
    buttonConfig = ButtonConfig(
        enabled = true,
        textSize = 16.sp,
        useBoldText = false,
        textPadding = 8.dp,
        buttonShape = ButtonShape.ROUNDED_CORNER,
        buttonCornerModifier = 8.dp,
        buttonColor = Color.Red,
        textColor = Color.White,
        disabledTextColor = Color.LightGray,
        disabledContainerColor = Color.DarkGray,
    )
)
````

## Future Work
- Allow custom font of text within button
- Allow small image to be placed in the button.
- Additional modifications for the shape of the button.
- More styles of button. ex: Outlined button, Borderless button
- Allow the user to pass a specific `TextStyle` for the text.