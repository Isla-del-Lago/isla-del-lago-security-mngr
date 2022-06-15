package com.isladellago.securitymngr.service

import com.isladellago.securitymngr.domain.dto.request.CreateTokenReq
import com.isladellago.securitymngr.domain.dto.request.ValidateTokenReq

interface JwtService {

    fun createToken(createTokenBody: CreateTokenReq): String

    fun validateToken(validateToken: ValidateTokenReq): Boolean
}