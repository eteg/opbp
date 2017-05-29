package br.com.eteg.opbp.entities.todo

import br.com.eteg.opbp.entities.base.BaseEntity
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Todo(
        @Id
        override var id: String? = null,

        var text: String? = null,

        var completed: Boolean? = false,

        var userId: Long? = null
) : BaseEntity<String>()