package br.com.eteg.opbp.repositories;

import br.com.eteg.opbp.entities.Account
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
interface AccountRepository : CrudRepository<Account, Long> {
    fun findByUsername(@Param("username") username: String?): Account?
}
