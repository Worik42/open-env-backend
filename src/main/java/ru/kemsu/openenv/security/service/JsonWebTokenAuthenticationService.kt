package ru.kemsu.openenv.security.service

import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.kemsu.openenv.exception.model.UserNotFoundException
import ru.kemsu.openenv.model.User
import ru.kemsu.openenv.model.UserAuthentication
import ru.kemsu.openenv.security.constants.SecurityConstants
import javax.servlet.http.HttpServletRequest


@Service
class JsonWebTokenAuthenticationService @Autowired constructor(private val userDetailsService: UserDetailsService) : TokenAuthenticationService {
    @Value("\${security.token.secret.key}")
    private val secretKey: String? = null

    override fun authenticate(request: HttpServletRequest): Authentication? {
        val token = request.getHeader(SecurityConstants.AUTH_HEADER_NAME)
        val tokenData = parseToken(token)
        if (tokenData != null) {
            val user = getUserFromToken(tokenData)
            return UserAuthentication(user)
        }
        return null
    }

    private fun parseToken(token: String?): Jws<Claims>? {
        return if (token != null) {
            try {
                Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            } catch (e: ExpiredJwtException) {
                null
            } catch (e: UnsupportedJwtException) {
                null
            } catch (e: MalformedJwtException) {
                null
            } catch (e: SignatureException) {
                null
            } catch (e: IllegalArgumentException) {
                null
            }
        } else null
    }

    private fun getUserFromToken(tokenData: Jws<Claims>): User {
        return try {
            userDetailsService
                    .loadUserByUsername(tokenData.body["username"].toString()) as User
        } catch (e: UsernameNotFoundException) {
            throw UserNotFoundException("User "
                    + tokenData.body["username"].toString() + " not found")
        }
    }

}
