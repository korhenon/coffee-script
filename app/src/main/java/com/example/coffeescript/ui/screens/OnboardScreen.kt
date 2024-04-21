package com.example.coffeescript.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.coffeescript.R
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.data.utils.OnboardPages
import com.example.coffeescript.ui.components.MaxWidthButton
import com.example.coffeescript.ui.components.MaxWidthOutlinedButton
import com.example.coffeescript.ui.theme.poppins
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardScreen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = {
        3
    })
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                Modifier
                    .fillMaxSize()
                    .paint(
                        painterResource(id = OnboardPages[it].image),
                        contentScale = ContentScale.Crop
                    )
                    .padding(horizontal = 31.dp)
            ) {
                Spacer(modifier = Modifier.height(236.dp))
                Text(
                    text = OnboardPages[it].title,
                    fontSize = 36.sp,
                    fontWeight = FontWeight.Bold,
                    lineHeight = 37.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = poppins
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Lorem ipsum dolor sit amet consectetur. Vestibulum eget blandit mattis",
                    fontSize = 14.sp,
                    color = colorScheme.primary,
                    lineHeight = 22.sp,
                    fontFamily = poppins,
                    textAlign = TextAlign.Center
                )
            }
            if (it == 2) {
                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    MaxWidthButton(text = "Register") {
                        navController.navigate(NavDestinations.Register)
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    MaxWidthOutlinedButton(text = "Sign in") {
                        navController.navigate(NavDestinations.Login)
                    }
                    Spacer(modifier = Modifier.height(56.dp))
                }
            }
        }
    }
    Box(Modifier.fillMaxSize()) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 30.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(Modifier.width(60.dp), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Box(
                    Modifier
                        .weight(if (pagerState.currentPage == 0) 2f else 1f)
                        .height(3.dp)
                        .background(
                            if (pagerState.currentPage == 0) colorScheme.primary else Color.White,
                            CircleShape
                        )
                )
                Box(
                    Modifier
                        .weight(if (pagerState.currentPage == 1) 2f else 1f)
                        .height(3.dp)
                        .background(
                            if (pagerState.currentPage == 1) colorScheme.primary else Color.White,
                            CircleShape
                        )
                )
                Box(
                    Modifier
                        .weight(if (pagerState.currentPage == 2) 2f else 1f)
                        .height(3.dp)
                        .background(
                            if (pagerState.currentPage == 2) colorScheme.primary else Color.White,
                            CircleShape
                        )
                )
            }
            Text(
                text = if (pagerState.currentPage != 2) "Skip" else "",
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                fontSize = 14.sp,
                modifier = Modifier.clickable {
                    coroutineScope.launch {
                        pagerState.scrollToPage(2)
                    }
                }
            )
        }
    }
}