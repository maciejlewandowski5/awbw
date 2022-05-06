package com.example.awbw.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Test1ViewModel @Inject constructor(): ViewModel() {

    private val _confirmationText: MutableLiveData<String?> = MutableLiveData("")
    val confirmationText: LiveData<String?> = _confirmationText

    private val _effect: MutableLiveData<Test1Effect?> = MutableLiveData(null)
    val effect: LiveData<Test1Effect?> = _effect

    fun setConfirmation(value: String?) {
        _confirmationText.value = value
    }

    fun confirmButtonCLicked() {
        if (_confirmationText.value == "Text") {
            _effect.value = Test1Effect.GoToSuccessScreen
        } else {
            _effect.value = Test1Effect.IncorrectInput
        }
    }
}
