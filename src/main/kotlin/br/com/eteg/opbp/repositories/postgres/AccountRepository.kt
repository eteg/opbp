package br.com.eteg.opbp.repositories.postgres

import br.com.eteg.opbp.entities.auth.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.web.bind.annotation.CrossOrigin

@CrossOrigin
@Repository
interface AccountRepository : JpaRepository<Account, Long> {
    fun findByUsername(@Param("username") username: String?): Account?
}
