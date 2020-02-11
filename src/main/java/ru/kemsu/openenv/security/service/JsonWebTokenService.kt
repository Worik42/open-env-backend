package ru.kemsu.openenv.security.service

import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import ru.kemsu.openenv.exception.model.ServiceException
import ru.kemsu.openenv.model.User
import java.time.LocalDateTime
import java.util.*


@Service
class JsonWebTokenService @Autowired constructor(@param:Qualifier("basicUserDetailsService") private val userDetailsService: UserDetailsService) : TokenService {
    private val log = LoggerFactory.getLogger(this.javaClass)
    @Value("\${security.token.secret.key}")
    private val tokenKey: String? = null

    override fun getToken(username: String, password: String): String? {
        if (username == null || password == null) {
            return null
        }
        val user = userDetailsService.loadUserByUsername(username) as User
        val tokenData: MutableMap<String, Any> = HashMap()
        return if (password == user.password) {
            tokenData["clientType"] = "user"
            tokenData["userID"] = user.id
            tokenData["username"] = user.username
            tokenData["token_create_date"] = LocalDateTime.now()
            val calendar = Calendar.getInstance()
            calendar.add(Calendar.MINUTE, tokenExpirationTime)
            tokenData["token_expiration_date"] = calendar.time
            val jwtBuilder = Jwts.builder()
            jwtBuilder.setExpiration(calendar.time)
            jwtBuilder.setClaims(tokenData)
            val jw = jwtBuilder.signWith(SignatureAlgorithm.HS512, tokenKey)
            jw.compact()
        } else {
            throw ServiceException("Authentication error", this.javaClass.name)
        }
    }

    companion object {
        private var tokenExpirationTime = 30
        fun setTokenExpirationTime(tokenExpirationTime: Int) {
            Companion.tokenExpirationTime = tokenExpirationTime
        }
    }

}
