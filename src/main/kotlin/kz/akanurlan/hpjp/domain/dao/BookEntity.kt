package kz.akanurlan.hpjp.domain.dao

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "books")
class BookEntity(

    @Id
    @Column
    val id: UUID? = null
)