package com.example.demo3navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo3navigation.ui.catalog.category.CategoryScreen
import com.example.demo3navigation.ui.catalog.product.ProductDetailScreen
import com.example.demo3navigation.ui.customer.MyAccountScreen
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
        NavHost(navController = navController, startDestination = "home") {
            composable("home") {
                HomeScreen(
                    openCategoryAction = {
                        navController.navigate("category")
                    },
                    openMyAccountScreen = { navController.navigate("myAccount") }
                ) { }
            }

            composable("category") {
                CategoryScreen(openProductDetail = { produceId ->
                    navController.navigate("productDetail/$produceId")
                })
            }
            composable(route = "productDetail/{produceId}",
                arguments = listOf(
                    navArgument(name = "produceId") {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val produceId = backStackEntry.arguments?.getString("produceId")
                requireNotNull(produceId)
                ProductDetailScreen(productId = produceId, checkout = { cartId, customerId ->
                })
            }

            composable("myAccount") {
                MyAccountScreen(
                    openAddressScreen = {},
                    navController = TODO()
                )
            }
        }
    }
}

//home: Màn hình chính (HomeScreen)
//category: Màn hình danh mục sản phẩm (CategoryScreen)
//productDetail/{produceId}: Màn hình chi tiết sản phẩm, truyền theo produceId