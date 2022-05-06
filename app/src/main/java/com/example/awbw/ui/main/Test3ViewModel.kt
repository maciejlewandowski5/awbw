package com.example.awbw.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class Test3ViewModel @Inject constructor() : ViewModel() {

    private val _email: MutableLiveData<String?> = MutableLiveData("")
    val email: LiveData<String?> = _email

    private val _password: MutableLiveData<String?> = MutableLiveData("")
    val password: LiveData<String?> = _password

    private val _isAgreed: MutableLiveData<Boolean> = MutableLiveData(false)
    val isAgreed: LiveData<Boolean> = _isAgreed

    private val _effect: MutableLiveData<Test3Effect?> = MutableLiveData(null)
    val effect: LiveData<Test3Effect?> = _effect

    fun setEmail(value: String?) {
        _email.value = value
    }

    fun setPassword(value: String?) {
        _password.value = value
    }

    fun setAgreed(checked: Boolean) {
        _isAgreed.value = checked
    }

    fun login() {
        if (_email.value == "test@test.test" && _password.value == "test" && _isAgreed.value == true) {
            _effect.value = Test3Effect.GoToSuccessScreen
        } else {
            _effect.value = Test3Effect.IncorrectCredentials
        }
    }
}
