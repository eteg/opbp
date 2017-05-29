package br.com.eteg.opbp.entities.auth

import br.com.eteg.opbp.entities.base.BaseEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

@Entity
class Account(
        @Id
        @GeneratedValue
        override var id: Long? = null,

        var username: String? = null,

        @JsonIgnore
        var password: String? = null,

        var name: String? = null,

        var email: String? = null,

        @ManyToMany
        @JoinTable(name = "AccountAuthority",
                joinColumns = arrayOf(JoinColumn(name = "account_id")),
                inverseJoinColumns = arrayOf(JoinColumn(name = "authority_id")))
        var authorities: List<Authority> = ArrayList<Authority>()
) : BaseEntity<Long>()