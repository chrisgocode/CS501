package com.example.helloworldbutton


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworldbutton.ui.theme.HelloWorldButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HelloWorldButtonTheme {
                HelloWorldScreen()
            }
        }
    }
}

@Composable
fun HelloWorldScreen() {
    // Create a state to track whether the text should be shown
    var showText by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Only show the text if showText is true
            if (showText) {
                Text("Hello World")
                // Add some space between the text and button
                Spacer(modifier = Modifier.height(16.dp))
            }

            Button(
                onClick = { showText = !showText },
                modifier = Modifier
                    .width(200.dp)
                    .height(60.dp)
            ) {
                Text("Click Me!")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HelloWorldPreview() {
    HelloWorldButtonTheme {
        HelloWorldScreen()
    }
}