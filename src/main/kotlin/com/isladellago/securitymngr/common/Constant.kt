package com.isladellago.securitymngr.common

object Constant {

    object Jwt {

        const val ISSUER = "com.isladellago"

        object Claims {
            const val ROLE = "role"
            const val USER_ID_CLAIM = "userId"
            const val EMAIL_CLAIM = "email"
        }
    }
}