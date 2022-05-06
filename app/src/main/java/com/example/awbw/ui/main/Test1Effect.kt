package com.example.awbw.ui.main

sealed class Test1Effect {
    object GoToSuccessScreen : Test1Effect()
    object IncorrectInput : Test1Effect()
}
