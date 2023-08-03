package com.br.myjetpackcomposeapplication.nav

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.br.myjetpackcomposeapplication.ui.AnotherScreen
import com.br.myjetpackcomposeapplication.ui.LoginScreen

@ExperimentalComposeUiApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalAnimationApi
@Preview
@Composable
fun MyNavigation(
    navController: NavHostController = rememberNavController(),
    startDestination: String = Destinations.START_DESTINATION
): NavHostController {
    return navController.apply {
        NavHost(
            navController = this,
            startDestination = startDestination
        ) {
            composable(route = Destinations.START_DESTINATION) { navBackEntryStack ->
                LoginScreen()
            }
            composable(route = Destinations.OTHER_SCREEN_DESTINATION) {
                AnotherScreen()
            }
        }
    }
}

object Destinations {
    const val START_DESTINATION = "login"
    const val OTHER_SCREEN_DESTINATION = "other"

}