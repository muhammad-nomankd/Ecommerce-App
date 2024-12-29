package com.durranitech.ecomerceapp.presentation.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.durranitech.ecomerceapp.data.model.BottomNavigationItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navyController: NavController) {

    val navigationBarItems = listOf<BottomNavigationItem>(
        BottomNavigationItem(
            title = "Home",
            selectedIcon = Icons.Default.Home,
            nonSelectedIcon = Icons.Outlined.Home,
            hasNews = false,
            route = "Home"
        ), BottomNavigationItem(
            title = "Cart",
            selectedIcon = Icons.Default.ShoppingCart,
            nonSelectedIcon = Icons.Outlined.ShoppingCart,
            hasNews = true,
            route = "Cart"
        ), BottomNavigationItem(
            title = "Favorite",
            selectedIcon = Icons.Default.Favorite,
            nonSelectedIcon = Icons.Outlined.FavoriteBorder,
            hasNews = false,
            badgeCount = 11,
            route = "Favorite"
        ), BottomNavigationItem(
            title = "Profile",
            selectedIcon = Icons.Default.Person,
            nonSelectedIcon = Icons.Outlined.Person,
            hasNews = false,
            route = "Profile"
        )
    )
    var currentlySelectedItem by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        val currentDestination = navyController.currentBackStackEntryAsState().value?.destination
        navigationBarItems.forEachIndexed { index, item ->
            NavigationBarItem(selected = currentDestination != null && currentDestination.route == item.route,
                onClick = {
                    currentlySelectedItem = index
                    navyController.navigate(item.route) {
                        popUpTo(navyController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = { Text(item.title, fontSize = 16.sp) },

                icon = {
                    BadgedBox(badge = {
                        if (item.badgeCount != null) {
                            Badge {
                                Text(item.badgeCount.toString())
                            }

                        } else if (item.hasNews) {
                            Badge()
                        }
                    }) {
                        Icon(
                            imageVector = if (index == currentlySelectedItem) {
                                item.selectedIcon
                            } else item.nonSelectedIcon, contentDescription = item.title
                        )

                    }
                })
        }
    }

}