package br.com.eteg.opbp.config

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpStatus
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        with(http!!) {
            csrf().disable()
            authorizeRequests().antMatchers("/rest/**").fullyAuthenticated()
            logout().logoutUrl("/signOut").permitAll()
                    .logoutSuccessHandler(HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK))
        }
    }
}
