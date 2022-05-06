package com.example.awbw.ui.main

sealed class Test3Effect {
    object GoToSuccessScreen : Test3Effect()
    object IncorrectCredentials : Test3Effect()
}
