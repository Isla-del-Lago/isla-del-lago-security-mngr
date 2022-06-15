package com.isladellago.securitymngr.domain.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy::class)
class ValidateTokenRes {

    var isValid: Boolean? = null
}