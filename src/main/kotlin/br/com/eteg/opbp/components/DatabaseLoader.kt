package br.com.eteg.opbp.components

import br.com.eteg.opbp.entities.auth.Account
import br.com.eteg.opbp.entities.auth.Authority
import br.com.eteg.opbp.entities.todo.Todo
import br.com.eteg.opbp.repositories.mongodb.TodoRepository
import br.com.eteg.opbp.repositories.postgres.AccountRepository
import br.com.eteg.opbp.repositories.postgres.AuthorityRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class DatabaseLoader(val userRepository: AccountRepository,
                     val authorityRepository: AuthorityRepository,
                     val todoRepository: TodoRepository) : CommandLineRunner {
    override fun run(vararg args: String?) {
        if (authorityRepository.count() == 0L) {
            authorityRepository.save(Authority(name = "ADMIN"))
            authorityRepository.save(Authority(name = "BASIC"))
        }

        if (userRepository.count() == 0L) {
            val adminAuthority = authorityRepository.findByName("ADMIN")!!
            val basicAuthority = authorityRepository.findByName("BASIC")!!

            val admin = userRepository.save(Account(username = "admin", password = "admin",
                    name = "Admin", email = "-", authorities = arrayListOf(adminAuthority, basicAuthority)))

            for (i in 1..5) {
                todoRepository.save(Todo(text = "Todo #${i}", userId = admin.id))
            }
        }
    }
}
