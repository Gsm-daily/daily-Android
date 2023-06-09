package com.daily.presentation.view.auth.signup

sealed interface SignUpState {
    fun previous(): SignUpState
    fun next(): SignUpState
}

object EmailInput: SignUpState {
    override fun previous() = this
    override fun next() = PasswordInput
}

object PasswordInput: SignUpState {
    override fun previous() = EmailInput
    override fun next() = NicknameInput
}

object NicknameInput: SignUpState {
    override fun previous() = PasswordInput
    override fun next() = this
}