package com.example.demo3navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo3navigation.ui.catalog.category.CategoryScreen
import com.example.demo3navigation.ui.catalog.product.ProductDetailScreen
import com.example.demo3navigation.ui.home.HomeScreen
import com.example.demo3navigation.ui.theme.Demo3NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            MainApp()
        }
    }
}


@Composable
fun MainApp() {
    val navController = rememberNavController()
    Demo3NavigationTheme {
        NavHost(navController = navController, startDestination = "home"){
            composable ("home"){
                HomeScreen(
                    openCategoryAction = {
                        navController.navigate("category")
                    },
                    openMyAccountScreen = {}
                ) { }
            }

            composable("category") {
                CategoryScreen (openProductDetail = {
                    produceId ->
                    navController.navigate("productDetail/$produceId")
                })
            }
//category: arguments setBudlle prouducId
//productDetail: lay ra arguments.getBudlle.getStrin...
            composable(route = "productDetail/{produceId}",
                arguments = listOf(
                    navArgument(name = "produceId"){
                        type = NavType.StringType
                    }
                )
            ) {
                backStackEntry ->
                val produceId = backStackEntry.arguments?.getString("produceId")
                requireNotNull(produceId)
                ProductDetailScreen(productId = produceId, checkout = {
                    cartId, customerId ->
                })
            }

        }
    }
}

//home: Màn hình chính (HomeScreen)
//category: Màn hình danh mục sản phẩm (CategoryScreen)
//productDetail/{produceId}: Màn hình chi tiết sản phẩm, truyền theo produceId