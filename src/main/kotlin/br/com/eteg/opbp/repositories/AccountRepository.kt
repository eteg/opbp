package br.com.eteg.opbp.repositories;

import br.com.eteg.opbp.entities.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
interface AccountRepository : MongoRepository<Account, Long> {
    fun findByUsername(@Param("username") username: String?): Account?
}
