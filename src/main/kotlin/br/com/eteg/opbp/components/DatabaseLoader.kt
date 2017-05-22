package br.com.eteg.opbp.components

import br.com.eteg.opbp.entities.Account
import br.com.eteg.opbp.repositories.AccountRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Component

@Component
class DatabaseLoader(val userRepository: AccountRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        with(userRepository) {
            if(count() == 0L) {
                save(Account(username = "admin", password = "admin",
                        name = "Admin", email = "-"))
            }
        }
    }
}
