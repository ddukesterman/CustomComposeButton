package com.heb.core.ui

import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.test.assertHasClickAction
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test


class ButtonInstrumentedTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun buttonClickTest() {
        var clicked = false
        val text = "Unit Test Click"

        composeTestRule.setContent {
            HebButton(onClick = { clicked = true; }, text = text)
        }

        composeTestRule
            .onNodeWithText(text)
            .performClick()

        assert(clicked)
    }

    @Test
    fun buttonDisabledTest() {
        val testTag = "test tag"

        composeTestRule.setContent {
            HebButton(
                modifier = Modifier.testTag(testTag),
                onClick = {},
                text = "Disabled",
                buttonConfig = ButtonConfig(
                    enabled = false
                )
            )
        }

        composeTestRule
            .onNodeWithTag(testTag)
            .assertIsNotEnabled()
    }

    @Test
    fun buttonTextTest() {
        val testTag = "test tag"

        composeTestRule.setContent {
            HebButton(
                modifier = Modifier.testTag(testTag),
                onClick = {},
                text = "Text Test",
                buttonConfig = ButtonConfig(
                    enabled = false
                )
            )
        }

        composeTestRule
            .onNodeWithTag(testTag)
            .assertTextEquals("Text Test")
    }

    @Test
    fun buttonClickableTest() {
        val testTag = "test tag"

        composeTestRule.setContent {
            HebButton(
                modifier = Modifier.testTag(testTag),
                onClick = {},
                text = "Clickable Test",
                buttonConfig = ButtonConfig(
                    enabled = false
                )
            )
        }

        composeTestRule
            .onNodeWithTag(testTag)
            .assertHasClickAction()
    }

    @Test
    fun isDisplayed() {
        val testTag = "test tag"

        composeTestRule.setContent {
            HebButton(
                modifier = Modifier.testTag(testTag),
                onClick = {},
                text = "Clickable Test",
                buttonConfig = ButtonConfig(
                    enabled = false
                )
            )
        }

        composeTestRule
            .onNodeWithTag(testTag)
            .assertIsDisplayed()
    }
}