package com.fuwafuwa.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.fuwafuwa.courses.model.Topic
import com.fuwafuwa.courses.ui.theme.CoursesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoursesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun courseCard(topic: Topic,modifier: Modifier= Modifier) {

    Card(){
        Row(){
            //Topic 클래스 미리 선언 
            Image(painter= painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId)
            )
            Text(text= stringResource(id = topic.stringResourceId))
        }


    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoursesTheme {

    }
}