package com.isladellago.securitymngr.controller

import com.isladellago.securitymngr.common.PathUtil
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin("*")
@RequestMapping(PathUtil.Token.ROOT_PATH)
class TokenController {

    @PostMapping()
    fun createToken() {

    }

    @PostMapping(PathUtil.Token.VALIDATE_TOKEN)
    fun validateToken() {

    }
}