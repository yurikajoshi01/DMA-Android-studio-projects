package com.example.diceroller

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceWithButtonAndImage(modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DiceRollerApp() {
    DiceRollerTheme {
        DiceWithButtonAndImage(modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
        )
    }
}

@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result1 by rememberSaveable { mutableStateOf(1) }
    var result2 by rememberSaveable { mutableStateOf(1) }
    var showDoubleRollMessage by rememberSaveable { mutableStateOf(false) }

    fun getImageResource (result: Int) = when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = getImageResource(result1)),
                contentDescription = "Dice $result1"
            )
            Spacer(modifier = Modifier.width(16.dp))
            Image(
                painter = painterResource(id = getImageResource(result2)),
                contentDescription = "Dice $result2"
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            result1 = (1..6).random()
            result2 = (1..6).random()
            showDoubleRollMessage = result1 == result2

        }) {
            Text("Roll")
        }
        if (showDoubleRollMessage && result1 == result2) {
        Text(
            "You rolled a double $result1",
            style = TextStyle(
                fontSize = 20.sp,
                textDecoration = TextDecoration.Underline
            )
        )
    }

    }

}