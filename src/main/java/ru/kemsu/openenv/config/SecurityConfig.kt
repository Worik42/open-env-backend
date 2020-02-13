package ru.kemsu.openenv.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.RequestMatcher
import org.springframework.web.cors.CorsUtils
import ru.kemsu.openenv.model.Authority
import ru.kemsu.openenv.security.filter.AuthenticationTokenFilter
import ru.kemsu.openenv.security.service.TokenAuthenticationService
import javax.servlet.http.HttpServletRequest

@EnableWebSecurity
open class SecurityConfig : WebSecurityConfigurerAdapter() {
    private var tokenAuthenticationService: TokenAuthenticationService? = null

    @Autowired
    protected fun SecurityConfig(tokenAuthenticationService: TokenAuthenticationService?) {
        this.tokenAuthenticationService = tokenAuthenticationService
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()
                .requestMatchers(RequestMatcher { request: HttpServletRequest -> CorsUtils.isPreFlightRequest(request) }).permitAll()
                .antMatchers("/api/auth").permitAll()
                .antMatchers("/api/v1/signup").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/api/v1/admin").hasAuthority(Authority.ROLE_ADMIN.authority)
                .anyRequest().authenticated()
                .and()
                .addFilterBefore(AuthenticationTokenFilter(tokenAuthenticationService!!),
                        UsernamePasswordAuthenticationFilter::class.java)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable()
    }
}