package kz.akanurlan.hpjp.domain.dao

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "companies")
class CompanyEntity(

    id: UUID? = null,

    @Column
    val name: String
): BaseEntity(id)