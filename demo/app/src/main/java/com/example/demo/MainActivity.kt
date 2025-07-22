package com.example.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.demo.ui.theme.DemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun HomeSreen() {
    Column(modifier = Modifier.padding(24.dp)) {
        BannerCompose(contentScale = ContentScale.Crop)

        Spacer(modifier = Modifier.height(24.dp))
        CircleAvatar()

        Spacer(modifier = Modifier.height(24.dp))
        UrlImageCompose()
//        BannerCompose(contentScale = ContentScale.Fit)
    }
}

@Composable
fun BannerCompose(contentScale: ContentScale) {
    Image(
        painterResource(id = R.drawable.img_demo),
        contentDescription = "Banner image",
        contentScale = contentScale,
        modifier = Modifier
            .height(150.dp)
            .fillMaxWidth().shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(size = 8.dp)
            ).aspectRatio(1f),
        alignment = Alignment.TopCenter
    )
}

@Composable
fun CircleAvatar() {
    Surface(
        modifier = Modifier
            .border(BorderStroke(2.dp, color = Color.Cyan), shape = CircleShape)
            .clip(shape = CircleShape)
    ) {
        Image(
            painterResource(id = R.drawable.cartoon),
            contentDescription = "Cartoon image",
            contentScale = ContentScale.Inside,
        )
    }
}

@Composable
fun UrlImageCompose(){
    Image(
        rememberAsyncImagePainter(model = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0mo1-1RPPCSd54lH3fcOeOWM1wRHxEZ3C1A&s"),
        contentDescription = null
    )
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    DemoTheme {
        HomeSreen()
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    DemoTheme {
//        Greeting("Android")
//    }
//}