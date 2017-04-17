package br.com.eteg.opbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.eteg.opbp.entities.Account;
import br.com.eteg.opbp.repository.AccountRepository;

@Profile("production")
@Configuration
public class GlobalAuthenticationConfiguration extends GlobalAuthenticationConfigurerAdapter {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public void init(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsService());
  }

  @Profile("production")
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      final Account account = accountRepository.findByUsername(username);

      if (null != account) {
        return new User(account.getUsername(), account.getPassword(),
            AuthorityUtils.createAuthorityList("USER"));
      } else {
        throw new UsernameNotFoundException("could not find the user " + username);
      }
    };
  }
}
