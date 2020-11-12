package com.example.applicationcomposelearning.widgets.home


import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.applicationcomposelearning.widgets.home.state.ReplaceAssetAnswer

@Composable
fun HomeContent(answers: List<ReplaceAssetAnswer>) {
    val selectedAnswer = remember { mutableStateOf<ReplaceAssetAnswer>(ReplaceAssetAnswer.Yes()) }
    Box {
        Column {
            YesNoWidget(answers, selectedAnswer) {
                selectedAnswer.value = it
            }
            Surface(modifier = Modifier.fillMaxSize(), color = Color.LightGray) {
                if (selectedAnswer.value is ReplaceAssetAnswer.Yes)
                    ReplaceAssetItemWidget()
            }
        }
        ButtonDone(Modifier.align(Alignment.BottomEnd))
    }
}

@Composable
fun YesNoWidget(
    answers: List<ReplaceAssetAnswer>,
    selectedAnswer: MutableState<ReplaceAssetAnswer>,
    onAnswerSelected: (ReplaceAssetAnswer) -> Unit
) {
    val selectedOption = remember { selectedAnswer }
    Surface(color = Color.White) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Did you replace asset?",
                modifier = Modifier.padding(8.dp)
            )
            Row {
                answers.forEach { answer ->
                    Row(
                        Modifier.padding(start = 8.dp, end = 64.dp, bottom = 8.dp, top = 8.dp)
                    ) {
                        RadioButton(
                            selected = (answer.title == selectedOption.value.title),
                            onClick = {
                                onAnswerSelected(answer)
                            }
                        )
                        Text(
                            text = answer.title,
                            modifier = Modifier.padding(start = 16.dp),
                            style = MaterialTheme.typography.body1.merge()
                        )
                    }
                }
            }
            Divider(color = Color.LightGray, thickness = 2.dp)
        }
    }
}

@Composable
fun ButtonDone(modifier: Modifier = Modifier) {
    Button(modifier = modifier.fillMaxWidth().padding(8.dp), onClick = {}) {
        Text(text = "Done", modifier = Modifier.padding(8.dp))
    }
}

@Preview(showDecoration = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ButtonDonePreview() {
    ButtonDone()
}
