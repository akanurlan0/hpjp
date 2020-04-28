package kz.akanurlan.hpjp.domain.repo

import kz.akanurlan.hpjp.domain.dao.PersonEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface PersonRepository : JpaRepository<PersonEntity, UUID> {
}