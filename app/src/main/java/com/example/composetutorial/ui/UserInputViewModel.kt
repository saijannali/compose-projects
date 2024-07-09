package com.example.composetutorial.ui

import android.text.BoringLayout
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.composetutorial.data.UserDataUiEvents
import com.example.composetutorial.data.UserInputScreenState

class UserInputViewModel : ViewModel() {
    companion object{
        const val TAG = "UserInputViewModel"
    }
    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvents) {
        when(event) {
            is UserDataUiEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
                Log.d(TAG, "onEvent:UserNameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }

            is UserDataUiEvents.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animalValue
                )
                Log.d(TAG, "onEvent:UserNameEntered->> ")
                Log.d(TAG, "${uiState.value}")
            }
        }
    }

    fun isValidState(): Boolean{
        return !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
    }
}
