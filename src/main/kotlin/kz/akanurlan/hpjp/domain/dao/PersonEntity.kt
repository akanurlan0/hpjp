package kz.akanurlan.hpjp.domain.dao

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "persons")
class PersonEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column
    val name: String
) {
    override fun toString(): String {
        return "{ id: $id, name: $name }"
    }
}