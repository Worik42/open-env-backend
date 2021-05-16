package ru.kemsu.openenv.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.oauth2.provider.token.TokenStore
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.web.filter.CorsFilter
import ru.kemsu.openenv.service.BasicUserService

@Configuration
//@Order(1)
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
class SecurityConfiguration : WebSecurityConfigurerAdapter() {
//    @Autowired
//    fun tokenStore(): TokenStore {
//        return InMemoryTokenStore()
//    }

    @Autowired
    fun tokenStore(): TokenStore {
        return JwtTokenStore(accessTokenConverter())
    }

    @Autowired
    fun accessTokenConverter(): JwtAccessTokenConverter {
        val converter = JwtAccessTokenConverter()
        converter.setSigningKey("openenv-client")
        return converter
    }


    @Autowired
    private val userDetailsService: BasicUserService? = null

    @Autowired
    @Throws(Exception::class)
    fun globalUserDetails(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
    }

//    @Throws(java.lang.Exception::class)
//    override fun configure(auth: AuthenticationManagerBuilder) { // @formatter:off
//        auth.inMemoryAuthentication()
//                .withUser("john")
//                .password(passwordEncoder().encode("123"))
//                .roles("USER")
//    } // @

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers("/v2/api-docs/**", "/api/swagger-ui/**").permitAll()
//        http.requestMatchers()
//                .antMatchers("/login", "/oauth/authorize")
//                .and()
//                .authorizeRequests()
//                .anyRequest()
//                .authenticated()
//                .and().csrf().disable();
    }

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager {
        return super.authenticationManagerBean()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun corsFilter(): FilterRegistrationBean<CorsFilter> {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration()
        config.allowCredentials = true
        config.addAllowedOrigin("*")
        config.addAllowedHeader("*")
        config.addAllowedMethod("*")
        source.registerCorsConfiguration("/**", config)
        val bean = FilterRegistrationBean(CorsFilter(source))
        bean.order = 0
        return bean
    }
}