package com.github.ebrahimi16153.paging3injetpack

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.github.ebrahimi16153.paging3injetpack.navigation.NavGraph
import com.github.ebrahimi16153.paging3injetpack.ui.theme.Paging3InJetPackTheme
import com.github.ebrahimi16153.paging3injetpack.util.Constant

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paging3InJetPackTheme {
                
                val navController = rememberNavController()
                NavGraph(navController = navController)

            }
        }
    }
}
