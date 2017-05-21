package br.com.eteg.opbp.entities

import br.com.eteg.opbp.entities.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name="account")
class Account(
        @Id
        @Column(name="id")
        @GeneratedValue
        override var id: Long? = null,

        @Column(name="username")
        var username: String? = null,

        @JsonIgnore
        @Column(name="password")
        var password: String? = null,

        @Column(name="name")
        var name: String? = null,

        @Column(name="email")
        var email: String? = null
) : BaseEntity<Long>()