package com.heb.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.heb.core.ui.ButtonConfig
import com.heb.core.ui.ButtonShape
import com.heb.core.ui.HebButton
import com.heb.sample.ui.theme.MyApplicationTheme

private val SPACER_HEIGHT = 24.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(text = "Default")
                        HebButton(onClick = { }, text = "Button")

                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "Rounded",
                        )
                        HebButton(
                            onClick = { },
                            text = "Button",
                            buttonConfig = ButtonConfig(buttonShape = ButtonShape.CIRCLE)
                        )

                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "Cut Corner",
                        )
                        HebButton(
                            onClick = { },
                            text = "Button",
                            buttonConfig = ButtonConfig(
                                buttonShape = ButtonShape.CUT_CORNER,
                                buttonCornerModifier = 16.dp)
                        )

                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "ExternalModifier, left padding",
                        )
                        HebButton(
                            onClick = { },
                            text = "Button",
                            modifier = Modifier.padding(start = 100.dp)
                        )

                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "Changed color",
                        )
                        HebButton(
                            onClick = { },
                            text = "Button",
                            buttonConfig = ButtonConfig(
                                buttonColor = Color(0xFFEE2824),
                                textColor = Color.Green,
                            )
                        )

                        Spacer(modifier = Modifier.height(SPACER_HEIGHT))
                        Text(
                            modifier = Modifier.padding(bottom = 4.dp),
                            text = "Disabled",
                        )
                        HebButton(
                            onClick = { },
                            text = "Button",
                            buttonConfig = ButtonConfig(
                                enabled = false
                            )
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplicationTheme {
        Greeting("Android")
    }
}