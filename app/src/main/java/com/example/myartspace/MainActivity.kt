package com.example.myartspace

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myartspace.data.ArtSpaceDatasource
import com.example.myartspace.model.arts

import com.example.myartspace.ui.theme.MyArtSpaceTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}


@Composable
fun ArtSpaceApp(){
    var clicks by remember { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        if(clicks >= arts.size) {
            clicks = 0
        }
        else if (clicks < 0 ) {
            clicks = arts.size - 1
        }
        ArtSpaceWithImage(arts[clicks].imageResourceId, arts[clicks].aboutImage,{clicks += 1}, {clicks -= 1})
    }
}

@Composable
fun ArtSpaceWithImage(iMageID: Int,
                      iMageAbt: String,
                      onNextClick: () -> Unit,
                      onPrevClick: () -> Unit,
                      modifier: Modifier = Modifier){
    Column(
        modifier = Modifier
            .wrapContentSize()
            .padding(top = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Card(
            elevation = 6.dp
        ) {
            Image(
                painter = painterResource(id = iMageID),
                contentDescription = "Drawing",
                modifier = Modifier
                    .size(340.dp)
                    .border(
                        BorderStroke(4.dp, Color.Gray), shape = RoundedCornerShape(
                            4.dp
                        )
                    )
                    .padding(16.dp)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "About")
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = iMageAbt)
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = onPrevClick,
                modifier = Modifier
                    .wrapContentHeight()
                    .width(120.dp)

            ) {
                Text(text = "Previous")

            }
            Spacer(modifier = Modifier.width(48.dp))
            Button(
                onClick =  onNextClick ,
                modifier = Modifier
                    .wrapContentHeight()
                    .width(120.dp)

            ) {
                Text(text = "Next")
            }
        }
    }

}

@Preview
@Composable
fun ArtAppPreview(){
    MyArtSpaceTheme{
        ArtSpaceApp()
    }
}

