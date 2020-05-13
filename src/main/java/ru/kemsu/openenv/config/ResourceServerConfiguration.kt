package ru.kemsu.openenv.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler
import ru.kemsu.openenv.model.Authority

@Configuration
@EnableResourceServer
class ResourceServerConfiguration : ResourceServerConfigurerAdapter() {
//    @Autowired
//    fun tokenStore(): TokenStore {
//        return JwtTokenStore(accessTokenConverter())
//    }
//
//    @Autowired
//    fun accessTokenConverter(): JwtAccessTokenConverter {
//        val converter = JwtAccessTokenConverter()
//        converter.setSigningKey("123")
//        return converter
//    }
//
//    @Autowired
//    @Primary
//    fun tokenServices(): DefaultTokenServices {
//        val defaultTokenServices = DefaultTokenServices()
//        defaultTokenServices.setTokenStore(tokenStore())
//        return defaultTokenServices
//    }
//
//    @Throws(Exception::class)
//    override fun configure(resources: ResourceServerSecurityConfigurer) {
//        resources.tokenServices(tokenServices()).resourceId(RESOURCE_ID).stateless(false)
//    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http.anonymous().and()
                .authorizeRequests()
                .antMatchers("/api/v1/signup").permitAll()
                .antMatchers("/v2/api-docs").permitAll()
                .antMatchers("/api/v1/admin").hasAuthority(Authority.ROLE_ADMIN.authority).anyRequest().authenticated()
                .and().exceptionHandling().accessDeniedHandler(OAuth2AccessDeniedHandler())
    }

    companion object {
        private const val RESOURCE_ID = "openenv-application"
    }
}