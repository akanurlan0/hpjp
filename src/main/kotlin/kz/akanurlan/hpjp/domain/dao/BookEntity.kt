package kz.akanurlan.hpjp.domain.dao

import org.hibernate.annotations.GenericGenerator
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
    @Column
    @GeneratedValue(generator="uuid")
    @GenericGenerator(name="uuid",strategy="uuid")
    val id: String? = null
)