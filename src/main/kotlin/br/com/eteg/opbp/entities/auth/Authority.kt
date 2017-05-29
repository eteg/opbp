package br.com.eteg.opbp.entities.auth

import br.com.eteg.opbp.entities.base.BaseEntity
import org.springframework.data.mongodb.core.index.Indexed
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Authority(
        @Id
        @GeneratedValue
        override var id: Long? = null,

        val name: String? = null
) : BaseEntity<Long>()