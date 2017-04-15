package br.com.eteg.opbp.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.web.bind.annotation.CrossOrigin

import br.com.eteg.opbp.entities.Todo
import br.com.eteg.opbp.entities.Account

@CrossOrigin
interface AccountRepository extends CrudRepository<Account, Integer> {
	Account findByUsername(String username)
}
