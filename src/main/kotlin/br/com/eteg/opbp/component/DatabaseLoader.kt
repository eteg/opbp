package br.com.eteg.opbp.component

import br.com.eteg.opbp.entities.Account
import br.com.eteg.opbp.repository.AccountRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseLoader(val userRepository: AccountRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        userRepository.save(Account(username = "dougefr", password = "123456",
                name = "Douglas Rodrigues", email = "dougefr@gmail.com"))
    }
}
