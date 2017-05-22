package br.com.eteg.opbp.repositories;

import br.com.eteg.opbp.entities.auth.Account
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
@Repository
interface AccountRepository : MongoRepository<Account, String> {
    fun findByUsername(@Param("username") username: String?): Account?
}
