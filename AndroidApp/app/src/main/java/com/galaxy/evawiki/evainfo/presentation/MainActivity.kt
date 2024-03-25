package com.galaxy.evawiki.evainfo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.galaxy.evawiki.evainfo.presentation.items.components.ItemsScreen
import com.galaxy.evawiki.evainfo.presentation.item.components.ItemScreen
import com.galaxy.evawiki.evainfo.presentation.util.Screen
import com.galaxy.evawiki.ui.theme.EvaWikiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvaWikiTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.ItemsScreen.route
                    ){
                        composable(route = Screen.ItemsScreen.route){
                            ItemsScreen(navController = navController)
                        }
                        composable(
                            route = Screen.ItemScreen.route + "?name={name}",
                            arguments = listOf(
                                navArgument(
                                    name = "name"
                                ){
                                    type = NavType.StringType
                                    defaultValue = ""
                                }
                            )

                        ){
                            ItemScreen()
                        }

                    }

                }
            }
        }
    }
}

