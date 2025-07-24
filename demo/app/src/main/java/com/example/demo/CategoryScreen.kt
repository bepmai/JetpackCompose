package com.example.demo

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.demo.ui.theme.DemoTheme


@Composable
fun CategoryScreen(modifier: Modifier = Modifier){

}

@Composable
@Preview(name = "Category Screen Preview", showBackground =  true, showSystemUi = true)
fun CategoryScreenPreview(){
    DemoTheme {
        CategoryScreen()
    }
}