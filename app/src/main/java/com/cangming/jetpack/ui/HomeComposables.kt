package com.cangming.jetpack.ui

import android.content.res.Configuration
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cangming.jetpack.R


@Composable
fun MessageCard(msg: Message) {
    Row(modifier = Modifier
        .padding(all = 8.dp)
        .semantics { testTag = "main_test_tag" }) {
        Image(painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "picture left",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape))
        Spacer(modifier = Modifier.width(8.dp))

        var isExpanded by remember { mutableStateOf(false) }

        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(text = msg.title,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.width(4.dp))
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = msg.body,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    style = MaterialTheme.typography.body2)
            }
        }
    }

}

data class Message(val title: String, val body: String)

//@Preview
//@Composable
//fun PreviewMessegeCard() {
//    MessageCard(msg = Message("Android", "Jetpack Compose"))
//}


//@Preview
//@Composable
//fun PreviewMessegeCard() {
//    MaterialTheme {
//        Surface {
//            MessageCard(msg = Message("Android", "Jetpack Compose"))
//        }
//    }
//}

@VisibleForTesting
@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .semantics { testTag = "list_tag_test" }) {
        messages.map { item { MessageCard(it) } }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewMessegeCard() {
    MaterialTheme {
        Surface {
            MessageCard(msg = Message("Android", "Jetpack Compose"))
        }
    }
}

@Preview
@Composable
fun PreviewConversation() {
    MaterialTheme {
        Conversation(SampleData.conversationSample)
    }
}