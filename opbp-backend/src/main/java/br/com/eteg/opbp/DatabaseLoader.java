package br.com.eteg.opbp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.eteg.opbp.entities.Account;
import br.com.eteg.opbp.repository.AccountRepository;

@Component
public class DatabaseLoader implements CommandLineRunner {

  @Autowired
  private AccountRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.save(new Account("dougefr", "123456"));
  }
}
