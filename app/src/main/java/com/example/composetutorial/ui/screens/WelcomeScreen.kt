package com.example.composetutorial.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.composetutorial.ui.FactComposable
import com.example.composetutorial.ui.FactsViewModel
import com.example.composetutorial.ui.TextComponent
import com.example.composetutorial.ui.TextWithShadow
import com.example.composetutorial.ui.TopBar

@Composable
fun WelcomeScreen(username: String?, animalSelected: String?) {
    println("=======Inside+WelcomeScreen")
    println("=======$username and $animalSelected")
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ){
            TopBar(value = "Welcome $username ")
            TextComponent(textValue = "Thank you! for sharing your data", textSize = 24.sp)

            Spacer(modifier = Modifier.size(60.dp))

            val finalText = if(animalSelected == "logo") "You are a money lover" else "You are a dog lover"
            TextWithShadow(value = finalText)

            val factsViewModel : FactsViewModel = viewModel()
            FactComposable(value = factsViewModel.generateRandomFact(animalSelected!!))
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview(){
    WelcomeScreen("username", "animalSelected")
}