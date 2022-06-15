package com.isladellago.securitymngr.domain.dto.request

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class CreateTokenReq {
    var userId: Int? = null
    var userEmail: String? = null
    var userRole: String? = null
}