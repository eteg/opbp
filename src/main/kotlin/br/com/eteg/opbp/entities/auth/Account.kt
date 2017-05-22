package br.com.eteg.opbp.entities.auth

import br.com.eteg.opbp.entities.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Account(
        @Id
        override var id: String? = null,

        var username: String? = null,

        @JsonIgnore
        var password: String? = null,

        var name: String? = null,

        var email: String? = null,

        @DBRef
        var authorities: List<Authority> = ArrayList<Authority>()
) : BaseEntity<String>()