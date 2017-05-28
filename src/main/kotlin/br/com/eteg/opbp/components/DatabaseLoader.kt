package br.com.eteg.opbp.components

import br.com.eteg.opbp.entities.auth.Account
import br.com.eteg.opbp.entities.auth.Authority
import br.com.eteg.opbp.repositories.AccountRepository
import br.com.eteg.opbp.repositories.AuthorityRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseLoader(val userRepository: AccountRepository, val authorityRepository: AuthorityRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (authorityRepository.count() == 0L) {
            authorityRepository.save(Authority(name = "ADMIN"))
            authorityRepository.save(Authority(name = "BASIC"))
        }

        if (userRepository.count() == 0L) {
            val adminAuthority = authorityRepository.findByName("ADMIN")!!
            val basicAuthority = authorityRepository.findByName("BASIC")!!

            userRepository.save(Account(username = "admin", password = "admin",
                    name = "Admin", email = "-", authorities = arrayListOf(adminAuthority, basicAuthority)))
        }
    }
}
