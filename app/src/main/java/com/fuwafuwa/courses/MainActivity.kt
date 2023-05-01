package com.fuwafuwa.courses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fuwafuwa.courses.data.DataSource
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

                    courseApp(DataSource.topics)

                }
            }
        }
    }
}

@Composable
fun courseApp(topicList: List<Topic>){
    courseList(topicList)
}

//
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun courseList(topicList: List<Topic>) {

    LazyVerticalGrid(cells = GridCells.Fixed(2) ){
        
        //items 파라미터 잘보고 사용하기
        items(topicList){
            topic -> courseCard(topic = topic)
            
        }

    }

}


@Composable
fun courseCard(topic: Topic, modifier: Modifier= Modifier) {

    Card(elevation = 3.dp,modifier=modifier.padding(8.dp)){
        Row(){
            //Topic 클래스 미리 선언 
            Image(painter= painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                modifier=Modifier.size(width = 68.dp, height = 68.dp),
                contentScale = ContentScale.Crop
            )
            Column(){
                Text(text= stringResource(id = topic.stringResourceId),
                    modifier=Modifier.padding(start=16.dp,end=16.dp,top=16.dp,bottom = 8.dp),
                    style = MaterialTheme.typography.subtitle2)

                Row(){
                Icon(painter= painterResource(id = R.drawable.ic_grain),
                contentDescription = null,
                modifier=Modifier
                    .width(40.dp)
                    .height(20.dp)
                    .padding(start=16.dp,end=8.dp)
                )
                Text(text= topic.courseCount.toString(),
                    style = MaterialTheme.typography.caption
                )
            }
            }
            }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CoursesTheme {
        //하나씩만 렌더링하기
        courseCard(Topic(R.string.tech, 118, R.drawable.tech))

    }
}