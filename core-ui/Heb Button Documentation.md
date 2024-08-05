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

## API

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

