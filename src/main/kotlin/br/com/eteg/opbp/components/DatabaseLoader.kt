package br.com.eteg.opbp.components

import br.com.eteg.opbp.entities.Account
import br.com.eteg.opbp.repositories.AccountRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseLoader(val userRepository: AccountRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        with(userRepository) {
            save(Account(username = "dougefr", password = "123456",
                    name = "Douglas Rodrigues", email = "dougefr@gmail.com"))
            save(Account(username = "admin", password = "123456",
                    name = "Admin", email = "-"))

            // Lista os usuários previamente criados
            for(user in findAll()){
                println(user)
            }
        }
    }
}
