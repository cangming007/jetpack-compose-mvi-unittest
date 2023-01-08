package com.cangming.jetpack

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.filters.MediumTest
import com.cangming.jetpack.ui.Conversation
import com.cangming.jetpack.ui.SampleData
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@MediumTest
@RunWith(JUnit4::class)
class AppUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            MaterialTheme{
                Surface {
                    Conversation(SampleData.conversationSample)
                }
            }
        }
    }

    @Test
    fun splashPlays() {
        composeTestRule.onNode(hasTestTag("list_tag_test")).assertIsDisplayed()
    }

}