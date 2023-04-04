package com.daily.presentation.view.auth.signup

sealed interface SignUpState {
    fun previous(): SignUpState
    fun next(): SignUpState
}

object EmailVerification: SignUpState {
    override fun previous() = this
    override fun next() = PasswordInput
}

object PasswordInput: SignUpState {
    override fun previous() = EmailVerification
    override fun next() = NicknameInput
}

object NicknameInput: SignUpState {
    override fun previous() = PasswordInput
    override fun next() = this
}