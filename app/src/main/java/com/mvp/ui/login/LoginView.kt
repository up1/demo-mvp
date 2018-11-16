package com.mvp.ui.login

import com.mvp.ui.IView

interface LoginView: IView {

    fun navigateToHome()

    fun onBackPress()

    fun onPasswordError()
}