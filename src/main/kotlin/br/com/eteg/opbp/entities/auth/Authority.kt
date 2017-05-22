package br.com.eteg.opbp.entities.auth

import br.com.eteg.opbp.entities.base.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Authority(
        @Id
        override var id: String? = null,

        @Indexed
        val name: String? = null
) : BaseEntity<String>()