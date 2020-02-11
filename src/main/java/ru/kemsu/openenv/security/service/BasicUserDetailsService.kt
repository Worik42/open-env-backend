package ru.kemsu.openenv.security.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import ru.kemsu.openenv.service.UserService

@Service
class BasicUserDetailsService @Autowired constructor(private val userService: UserService) : UserDetailsService {
    @Throws(UsernameNotFoundException::class)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userService.findByUsername(username)
        return user ?: throw UsernameNotFoundException("User with username:$username not found")
    }

}
