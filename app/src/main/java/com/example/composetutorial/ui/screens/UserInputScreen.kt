package com.example.composetutorial.ui.screens

import android.view.Display.Mode
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.composetutorial.R
import com.example.composetutorial.data.UserDataUiEvents
import com.example.composetutorial.ui.AnimalCard
import com.example.composetutorial.ui.ButtonComponent
import com.example.composetutorial.ui.TextComponent
import com.example.composetutorial.ui.TextFieldComponent
import com.example.composetutorial.ui.TopBar
import com.example.composetutorial.ui.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel) {
    Surface(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(18.dp)) {
            TopBar(value = "Hi there \uD83D\uDE0A")

            TextComponent(textValue = "Let's learn about these", textSize = 24.sp)

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "this app with prep details page based on input provided by yoy", textSize = 18.sp)

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textValue = "Name", textSize = 18.sp)
            Spacer(modifier = Modifier.size(10.dp))
            TextFieldComponent(onTextChanged = {
                userInputViewModel.onEvent(
                    UserDataUiEvents.UserNameEntered(it)
                )
            })

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textValue = "What do you like", textSize = 18.sp )

            Row(modifier = Modifier.fillMaxWidth()) {
                AnimalCard(image = R.drawable.main_logo, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="logo")

                AnimalCard(image = R.drawable.ic_launcher_background, animalSelected = {
                    userInputViewModel.onEvent(
                        UserDataUiEvents.AnimalSelected(it)
                    )
                }, selected = userInputViewModel.uiState.value.animalSelected=="dog")
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState()) {
                ButtonComponent(
                    goToDetailsScreen = {
                        println("====================Coming Here")
                        println("====================${userInputViewModel.uiState.value.nameEntered} and ${userInputViewModel.uiState.value.animalSelected}")
                    }
                )
            }


        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel())
}
