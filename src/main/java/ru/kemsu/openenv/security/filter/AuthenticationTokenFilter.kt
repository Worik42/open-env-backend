package ru.kemsu.openenv.security.filter

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import ru.kemsu.openenv.security.service.TokenAuthenticationService
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class AuthenticationTokenFilter(private val authenticationService: TokenAuthenticationService) : GenericFilterBean() {
    @Throws(IOException::class, ServletException::class)
    override fun doFilter(request: ServletRequest, response: ServletResponse,
                          filterChain: FilterChain) {
        val httpRequest = request as HttpServletRequest
        val authentication = authenticationService.authenticate(httpRequest)
        SecurityContextHolder.getContext().authentication = authentication
        filterChain.doFilter(request, response)
        SecurityContextHolder.getContext().authentication = null
    }

}