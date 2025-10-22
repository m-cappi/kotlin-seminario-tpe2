package com.example.seminariotp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.seminariotp.ui.filters.FiltersScreen
import com.example.seminariotp.ui.games.GamesRoute
import com.example.seminariotp.ui.games.GamesScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val gameViewModel: GameViewModel by viewModels()
    private val filtersViewModel: FiltersViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "games") {
                composable(
                    route = "games",
                ) { navBackStackEntry ->
                    val savedStateHandle = navBackStackEntry.savedStateHandle
                    val route: GamesRoute =
                        savedStateHandle.get<GamesRoute>("gamesRoute") ?: GamesRoute()
                    GamesScreen(
                        viewModel = gameViewModel,
                        gamesRoute = route,
                        goFilters = {
                            navController.navigate(route = "filters")
                        }
                    )
                }
                composable(route = "filters") {
                    FiltersScreen(
                        filtersViewModel,
                        goGames = { gamesRoute ->
                            navController.currentBackStackEntry
                                ?.savedStateHandle
                                ?.set("gamesRoute", gamesRoute)
                            navController.navigate(route = "games")
                        }
                    )
                }
            }

        }
    }
}
//            SeminarioTPTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                }
//            }

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    SeminarioTPTheme {
//        Greeting("Android")
//    }
//}