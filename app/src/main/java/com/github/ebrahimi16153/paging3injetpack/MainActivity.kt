package com.github.ebrahimi16153.paging3injetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi16153.paging3injetpack.navigation.NavGraph
import com.github.ebrahimi16153.paging3injetpack.ui.theme.Paging3InJetPackTheme
import com.github.ebrahimi16153.paging3injetpack.util.Constant
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3InJetPackTheme {

                Log.i("apikey",Constant.API_KEY)
                
                val navController = rememberNavController()
                NavGraph(navController = navController)

            }
        }
    }
}
