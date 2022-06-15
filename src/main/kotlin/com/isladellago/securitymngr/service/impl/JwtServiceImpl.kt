package com.isladellago.securitymngr.service.impl

import com.isladellago.securitymngr.common.Constant
import com.isladellago.securitymngr.domain.dto.request.CreateTokenReq
import com.isladellago.securitymngr.domain.dto.request.ValidateTokenReq
import com.isladellago.securitymngr.service.JwtService
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.MalformedJwtException
import io.jsonwebtoken.UnsupportedJwtException
import io.jsonwebtoken.security.Keys
import io.jsonwebtoken.security.SignatureException
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import java.nio.charset.StandardCharsets
import java.util.*

@Service
class JwtServiceImpl(@Value("\${jwt.signature.secret}") private val jwtSignatureSecret: String) : JwtService {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun createToken(createTokenBody: CreateTokenReq): String {
        log.info("[Create token service] User email: {}", createTokenBody.userEmail)

        val token = Jwts.builder()
            .setSubject(createTokenBody.userEmail)
            .claim(Constant.Jwt.Claims.USER_ID_CLAIM, createTokenBody.userId)
            .claim(Constant.Jwt.Claims.EMAIL_CLAIM, createTokenBody.userEmail)
            .claim(Constant.Jwt.Claims.ROLE, createTokenBody.userRole)
            .setIssuer(Constant.Jwt.ISSUER)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
            .signWith(Keys.hmacShaKeyFor(jwtSignatureSecret.byteInputStream(StandardCharsets.UTF_8).readAllBytes()))
            .compact()

        log.info("[Create token service] User email: {} Token generated: {}",
            createTokenBody.userEmail, token)

        return token
    }

    override fun validateToken(validateToken: ValidateTokenReq): Boolean {
        try {
            log.info("[Validate token service] Token to be validated: {}",
                validateToken.token)

            val key = Keys.hmacShaKeyFor(
                jwtSignatureSecret.byteInputStream(StandardCharsets.UTF_8).readAllBytes()
            )

            Jwts.parserBuilder().setSigningKey(key)
                .build().parseClaimsJws(validateToken.token)

            log.info("[Validate token service] Token validated successfully")
            return true
        } catch (ex: SignatureException) {
            log.error("Invalid JWT token - {}", ex.message)
        } catch (ex: MalformedJwtException) {
            log.error("Invalid JWT token - {}", ex.message)
        } catch (ex: ExpiredJwtException) {
            log.error("Expired JWT token - {}", ex.message)
        } catch (ex: UnsupportedJwtException) {
            log.error("Unsupported JWT token - {}", ex.message)
        } catch (ex: IllegalArgumentException) {
            log.error("JWT claims string is empty - {}", ex.message)
        }

        log.info("[Validate token service] Token not validated successfully")

        return false
    }

}