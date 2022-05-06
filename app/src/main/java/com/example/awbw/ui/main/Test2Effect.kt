package com.example.awbw.ui.main

sealed class Test2Effect {
    object GoToSuccessScreen : Test2Effect()
    object WrongButton: Test2Effect()
}
