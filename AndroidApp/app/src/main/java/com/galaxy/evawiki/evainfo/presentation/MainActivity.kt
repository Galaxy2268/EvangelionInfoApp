package com.galaxy.evawiki.evainfo.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.galaxy.evawiki.evainfo.presentation.item.components.ItemScreen
import com.galaxy.evawiki.evainfo.presentation.items.components.ItemsScreen
import com.galaxy.evawiki.evainfo.presentation.util.Screen
import com.galaxy.evawiki.ui.theme.EvaWikiTheme
import com.galaxy.evawiki.util.Event
import com.galaxy.evawiki.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvaWikiTheme {
                val lifecycle = LocalLifecycleOwner.current.lifecycle
                LaunchedEffect(key1 = lifecycle) {
                    repeatOnLifecycle(state = Lifecycle.State.STARTED){
                        EventBus.events.collect { event ->
                            if(event is Event.Toast){
                                Toast.makeText(this@MainActivity, event.message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    }
                }
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
                            route = Screen.ItemScreen.route + "?id={id}&type={type}",
                            arguments = listOf(
                                navArgument(name = "id"){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                                navArgument(name = "type"){
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

