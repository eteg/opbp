package br.com.eteg.opbp.entities.base

import java.io.Serializable

open class BaseEntity<ID : Serializable> : Serializable {
    open var id: ID? = null

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as BaseEntity<*>

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "${this.javaClass.name}(id=$id)"
    }
}