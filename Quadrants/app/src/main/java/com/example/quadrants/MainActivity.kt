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
import androidx.compose.ui.res.stringResource
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
                topic = stringResource(R.string.first_title),
                description = stringResource(R.string.first_description),
                modifier = Modifier.weight(1f)
            )
            CardMessage(
                color = Color(0xFFD0BCFF),
                topic = stringResource(R.string.second_title),
                description = stringResource(R.string.second_description),
                modifier = Modifier.weight(1f)
            )
        }

        Row(Modifier.weight(1f)) {
            CardMessage(
                color = Color(0xFFB69DF8),
                topic = stringResource(R.string.third_title),
                description = stringResource(R.string.third_description),
                modifier = Modifier.weight(1f)
            )
            CardMessage(
                color = Color(0xFFF6EDFF),
                topic = stringResource(R.string.fourth_title),
                description = stringResource(R.string.fourth_description),
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