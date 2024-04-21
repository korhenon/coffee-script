package com.example.coffeescript.ui.screens

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
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavController
import com.example.coffeescript.R
import com.example.coffeescript.data.utils.NavDestinations
import com.example.coffeescript.ui.components.AuthField
import com.example.coffeescript.ui.components.MaxWidthButton
import com.example.coffeescript.ui.theme.poppins

@Composable
fun RegisterScreen(navController: NavController) {
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.auth),
                contentScale = ContentScale.Crop
            ),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
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
                text = "Register your Account",
                fontSize = 24.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Spacer(modifier = Modifier.height(28.dp))
            AuthField(placeholder = "Full Name", value = fullName) {
                fullName = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            AuthField(placeholder = "E-mail Address", value = email) {
                email = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            AuthField(placeholder = "Password", value = password) {
                password = it
            }
            Spacer(modifier = Modifier.height(10.dp))
            AuthField(placeholder = "Confirm Password", value = confirmPassword) {
                confirmPassword = it
            }
            Spacer(modifier = Modifier.height(29.dp))
            MaxWidthButton(text = "Sign in") {

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
                    .background(MaterialTheme.colorScheme.primary)
            )
            Text(
                text = "Or Register with",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = poppins
            )
            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(2.dp)
                    .background(MaterialTheme.colorScheme.primary)
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
        Spacer(modifier = Modifier.height(28.dp))
        Text(
            text = buildAnnotatedString {
                append("Already have an account ? ")
                withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)) {
                    append("Login")
                }
            },
            fontFamily = poppins,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.clickable { navController.navigate(NavDestinations.Login) }
        )
        Spacer(modifier = Modifier.height(68.dp))
    }

}