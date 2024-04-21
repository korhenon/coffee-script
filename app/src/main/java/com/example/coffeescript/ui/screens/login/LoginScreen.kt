package com.example.coffeescript.ui.screens.login

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeescript.R
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.ui.components.AuthField
import com.example.coffeescript.ui.components.MaxWidthButton
import com.example.coffeescript.ui.theme.poppins

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {
    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.auth),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(20.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(80.dp))
            Image(painter = painterResource(id = R.drawable.logo_small), contentDescription = "")
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Welcome to Login",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Spacer(modifier = Modifier.height(28.dp))
            AuthField(placeholder = "E-mail Address", value = viewModel.state.username) {
                viewModel.state = viewModel.state.copy(username = it)
            }
            Spacer(modifier = Modifier.height(10.dp))
            AuthField(placeholder = "Password", value = viewModel.state.password) {
                viewModel.state = viewModel.state.copy(password = it)
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Forgot Password?",
                color = colorScheme.primary,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = poppins,
                textAlign = TextAlign.End,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))
            MaxWidthButton(text = "Sign in") {
                viewModel.login(navController)
            }
        }
        Spacer(modifier = Modifier.height(40.dp))
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(colorScheme.primary)
            )
            Text(
                text = "Or Login with",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(colorScheme.primary)
            )
        }
        Spacer(modifier = Modifier.height(28.dp))
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .width(98.dp)
                    .background(Color(0xB3101215), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "")
            }
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .width(98.dp)
                    .background(Color(0xB3101215), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.google), contentDescription = "")
            }
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .width(98.dp)
                    .background(Color(0xB3101215), RoundedCornerShape(10.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(painter = painterResource(id = R.drawable.twitter), contentDescription = "")
            }
        }
    }
    Column(
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            text = buildAnnotatedString {
                append("Don’t have an account ? ")
                withStyle(SpanStyle(color = colorScheme.primary, fontWeight = FontWeight.Bold)) {
                    append("Register")
                }
            },
            fontFamily = poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { navController.navigate(NavDestinations.Register) }
        )
        Spacer(modifier = Modifier.height(68.dp))
    }
}