package br.com.eteg.opbp.entities

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Account(
        @Id @GeneratedValue
        var id: Int? = null,
        var username: String? = null,
        @JsonIgnore
        var password: String? = null,
        var name: String? = null,
        var email: String? = null
)