package com.example.quadrants

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.quadrants.ui.theme.QuadrantsTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeQuadrants()
                }
            }
        }
    }
}

@Composable
fun ComposeQuadrants(){
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            CardMessage(
                color = Color(0xFFEADDFF),
                topic = "Text composable",
                description = "Displays text and follows the recommended Material Design guidelines.",
                modifier = Modifier.weight(1f)
            )
            CardMessage(
                color = Color(0xFFD0BCFF),
                topic = "Image composable",
                description = "Creates a composable that lays out and draws a given Painter class object.",
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            CardMessage(
                color = Color(0xFFB69DF8),
                topic = "Row composable",
                description = "A layout composable that places its children in a horizontal sequence.",
                modifier = Modifier.weight(1f)
            )
            CardMessage(
                color = Color(0xFFF6EDFF),
                topic = "Column composable",
                description = "A layout composable that places its children in a vertical sequence.",
                modifier = Modifier.weight(1f)
            )
        }
    }

}

@Composable
fun CardMessage(topic: String, description: String, modifier: Modifier = Modifier, color: Color){
    Column (modifier = modifier
        .background(color)
        .padding(16.dp)
        .fillMaxHeight(),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(
            text = topic,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)

        )

        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}



@Preview(showBackground = true)
@Composable
fun QuadrantsPreview() {
    QuadrantsTheme {
        ComposeQuadrants()
    }
}