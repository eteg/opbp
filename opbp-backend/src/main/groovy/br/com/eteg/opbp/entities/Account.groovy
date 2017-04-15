package br.com.eteg.opbp.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account {
	@Id @GeneratedValue Integer id
	String username
	String password
}
