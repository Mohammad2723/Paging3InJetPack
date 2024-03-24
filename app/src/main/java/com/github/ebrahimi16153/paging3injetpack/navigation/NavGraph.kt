package com.github.ebrahimi16153.paging3injetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.ExperimentalPagingApi
import com.github.ebrahimi16153.paging3injetpack.screens.home.HomeScreen
import com.github.ebrahimi16153.paging3injetpack.screens.search.SearchScreen

@OptIn(ExperimentalPagingApi::class)
@Composable
fun NavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = Screen.Home.route ){

        //home
        composable(route = Screen.Home.route){
               HomeScreen(navController = navController)
        }

        //search
        composable(route = Screen.Search.route){
            SearchScreen(navController = navController)
        }





    }
}