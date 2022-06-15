package com.isladellago.securitymngr.controller

import com.isladellago.securitymngr.common.PathUtil
import com.isladellago.securitymngr.domain.dto.request.CreateTokenReq
import com.isladellago.securitymngr.domain.dto.request.ValidateTokenReq
import com.isladellago.securitymngr.domain.dto.response.CreateTokenRes
import com.isladellago.securitymngr.domain.dto.response.ValidateTokenRes
import com.isladellago.securitymngr.service.JwtService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(PathUtil.Token.ROOT_PATH)
@CrossOrigin
class TokenController(private val jwtService: JwtService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createToken(@RequestBody createTokenBody: CreateTokenReq) = CreateTokenRes().apply {
        accessToken = jwtService.createToken(createTokenBody)
    }

    @PostMapping(PathUtil.Token.VALIDATE_TOKEN)
    @ResponseStatus(HttpStatus.OK)
    fun validateToken(@RequestBody token: ValidateTokenReq) = ValidateTokenRes().apply {
        isValid = jwtService.validateToken(token)
    }
}