package br.com.eteg.opbp

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException

import br.com.eteg.opbp.entities.Account
import br.com.eteg.opbp.repository.AccountRepository

@Configuration
class GlobalAuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	AccountRepository userRepository

	@Override
	void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService userDetailsService()
	}

	@Bean
	UserDetailsService userDetailsService(){
		return [
			loadUserByUsername: { username ->
				final Account account = userRepository.findByUsername(username)

				if(account){
					return new User(account.username, account.password,
							AuthorityUtils.createAuthorityList("USER"))
				} else {
					throw new UsernameNotFoundException("could not find the user '${username}'")
				}
			}
		] as UserDetailsService
	}
}
