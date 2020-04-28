package kz.akanurlan.hpjp.domain.dao

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "books")
class BookEntity(

    @Id
    @GeneratedValue
    val id: UUID? = null,

    @Column
    val name: String
) {
    override fun toString(): String {
        return "{ id: $id, name: $name }"
    }
}