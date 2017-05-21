package br.com.eteg.opbp.config

import br.com.eteg.opbp.entities.Account
import br.com.eteg.opbp.repository.AccountRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

@Configuration
class GlobalAuthenticationConfiguration(val accountRepository: AccountRepository) :
        GlobalAuthenticationConfigurerAdapter() {
    override fun init(auth: AuthenticationManagerBuilder) {
        auth.userDetailsService(userDetailsService())
    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        return UserDetailsService { username ->
            val account: Account? = accountRepository.findByUsername(username)

            if (null != account) {
                User(account.username, account.password, AuthorityUtils.createAuthorityList("USER"))
            } else {
                throw UsernameNotFoundException("could not find the user ${username}")
            }
        }
    }
}
