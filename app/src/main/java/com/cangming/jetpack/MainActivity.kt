package com.cangming.jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.core.view.WindowCompat
import com.cangming.jetpack.ui.Conversation
import com.cangming.jetpack.ui.LoginCompose
import com.cangming.jetpack.ui.SampleData
import dagger.hilt.android.AndroidEntryPoint

/**
 *  首页
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            MaterialTheme{
                Surface {
//                    Conversation(SampleData.conversationSample)
                    LoginCompose()
                }
            }
        }
    }
}