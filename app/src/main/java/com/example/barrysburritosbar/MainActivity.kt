package com.example.barrysburritosbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.barrysburritosbar.component.BarrysBurritoBarBottomBar
import com.example.barrysburritosbar.component.BarrysBurritosBarAppBar
import com.example.barrysburritosbar.component.NavButton
import com.example.barrysburritosbar.data.DataSource
import com.example.barrysburritosbar.screen.BasketScreen
import com.example.barrysburritosbar.screen.BurritoScreenDetails
import com.example.barrysburritosbar.screen.BurritosScreen
import com.example.barrysburritosbar.screen.CustomBurritoScreen
import com.example.barrysburritosbar.ui.theme.BarrysBurritosBar
import com.example.barrysburritosbar.screen.HomeScreen


enum class BarryBurritoScreen() {
    Home,
    Custom_Burrito,
    Burritos,
    Basket,
    BurritosDetail
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BarrysBurritosBar{
                BarrysBurritosBarApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BarrysBurritosBarApp(
    navController: NavHostController = rememberNavController()
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                BarrysBurritosBarAppBar()
            },
            bottomBar = {
                BarrysBurritoBarBottomBar(
                    navOptions = DataSource.navoptions,
                    OnNavOptionsClicked = { selectedOption ->
                        navController.navigate(BarryBurritoScreen.values()[selectedOption].name )},
                    modifier = Modifier.fillMaxSize()
                )
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = BarryBurritoScreen.Home.name,
                modifier = Modifier.padding(innerPadding)
            ) {
                composable(route = BarryBurritoScreen.Home.name) {
                    HomeScreen(
                        navOptions = DataSource.navoptions,
                        OnNavOptionsClicked = { selectedOption ->
                            navController.navigate(BarryBurritoScreen.values()[selectedOption].name)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }
                composable(route = BarryBurritoScreen.Custom_Burrito.name) {
                    CustomBurritoScreen(
                        navOptions = DataSource.navoptions,
                        OnNavOptionsClicked = { selectedOption ->
                            navController.navigate(BarryBurritoScreen.values()[selectedOption].name)
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }

                composable(route = BarryBurritoScreen.Burritos.name) {
                    BurritosScreen(
                        navOptions = DataSource.navoptions,
                        OnNavOptionsClicked = { selectedOption ->
                            navController.navigate(BarryBurritoScreen.values()[selectedOption].name)
                        },
                        // sends user to the burritosDetails screen, the chosen burrito is passed through so the correct details are displayed.
                        onBurritoClicked = { burritoItem ->
                            navController.navigate(
                                "${BarryBurritoScreen.BurritosDetail.name}/${burritoItem.joinToString(",")}"
                            )
                        },
                        modifier = Modifier.fillMaxSize()
                    )
                }

                composable(route = BarryBurritoScreen.Basket.name) {
                    BasketScreen(
                        navOptions = DataSource.navoptions,
                        OnNavOptionsClicked = { selectedOption ->
                            navController.navigate(BarryBurritoScreen.values()[selectedOption].name)
                        },
                        currentOrder = DataSource.CurrentOrder,
                        lastOrder = DataSource.LastOrder,
                        modifier = Modifier.fillMaxSize()

                    )
                }

                // receives burritoItem as an arrangement so the correct burrito is shown
                composable(
                    route = "${BarryBurritoScreen.BurritosDetail.name}/{burritoItem}",
                    arguments = listOf(navArgument("burritoItem") { type = NavType.StringType })
                ) { navBackStackEntry ->
                    val burritoItemString = navBackStackEntry.arguments?.getString("burritoItem")
                    val burritoItem = burritoItemString?.split(",") ?: emptyList()

                    BurritoScreenDetails(
                        navOptions = DataSource.navoptions,
                        OnNavOptionsClicked = { selectedOption ->
                            navController.navigate(BarryBurritoScreen.values()[selectedOption].name)
                        },
                        OnBackButtonClicked = { navController.navigate(BarryBurritoScreen.Burritos.name) },
                        burritoItem = burritoItem,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun BarrysBurritosBarAppBarPreview(

) {
//    BarrysBurritosBarAppBar()

    BarrysBurritosBarApp()
}
