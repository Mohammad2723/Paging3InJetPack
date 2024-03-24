package com.github.ebrahimi16153.paging3injetpack.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.github.ebrahimi16153.paging3injetpack.screens.common.ListContent
import com.github.ebrahimi16153.paging3injetpack.viewmodel.HomeViewModel

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen(navController: NavController,homeViewModel: HomeViewModel = hiltViewModel()){

    val allImages = homeViewModel.allImages.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {
        Surface(modifier = Modifier.padding(it)) {
            ListContent(items = allImages.itemSnapshotList.items )
        }
    }


}