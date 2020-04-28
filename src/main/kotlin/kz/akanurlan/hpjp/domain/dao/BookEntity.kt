package kz.akanurlan.hpjp.domain.dao

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "books")
class BookEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column
    val name: String,

    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    val comments: MutableList<CommentEntity> = mutableListOf()
) {
    override fun toString(): String {
        return "{ id: $id, name: $name }"
    }
}