package com.example.coffeescript.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.coffeescript.R
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.ui.components.MaxWidthButtonMini

@Composable
fun SplashScreen(navController: NavController) {
    Column(
        Modifier
            .fillMaxSize()
            .paint(painterResource(id = R.drawable.splash), contentScale = ContentScale.Crop)
            .padding(start = 74.dp, end = 74.dp, top = 233.dp, bottom = 84.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "")
        MaxWidthButtonMini(text = "Get Started") {
            navController.navigate(NavDestinations.Onboard)
        }
    }
}