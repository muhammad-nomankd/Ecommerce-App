package com.durranitech.ecomerceapp

import android.app.StatusBarManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.durranitech.ecomerceapp.presentation.ui.screen.BottomNavigationBar
import com.durranitech.ecomerceapp.presentation.ui.screen.MainContent
import com.durranitech.ecomerceapp.ui.theme.EcomerceAppTheme
import com.durranitech.ecomerceapp.ui.theme.MyCustomColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EcomerceAppTheme {

                // Changing Status bar color in Material 3 while in Material 2 it was used to set from themes.xml file
                setSystemBarColr(MyCustomColor)

                val navControler = rememberNavController()
                Scaffold( modifier = Modifier.background(Color.White).fillMaxSize(),bottomBar = {
                    BottomNavigationBar(navControler)
                }) { paddingValues ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues)
                    ) {
                        MainContent(navController = navControler)
                    }
                }


            }
        }
    }

    @Composable
    fun setSystemBarColr(color: Color){
        val systemUiController = rememberSystemUiController()
        val isDarkTheme = isSystemInDarkTheme()

        systemUiController.setStatusBarColor(
            color = color,
            darkIcons = !isDarkTheme
        )
    }
}

