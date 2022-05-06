package com.example.awbw.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Test2ViewModel @Inject constructor(): ViewModel() {

    private val _effect: MutableLiveData<Test2Effect?> = MutableLiveData(null)
    val effect: LiveData<Test2Effect?> = _effect

    fun wrongButtonClicked() {
        _effect.value = Test2Effect.WrongButton
    }

    fun correctButtonClicked() {
        _effect.value = Test2Effect.GoToSuccessScreen
    }
}
