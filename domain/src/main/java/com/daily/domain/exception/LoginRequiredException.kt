package com.daily.domain.exception

import java.io.IOException

class LoginRequiredException: IOException() {
    override val message: String
        get() = "인증 토큰이 만료되었습니다. 다시 로그인 해주세요"
}