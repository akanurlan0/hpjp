package kz.akanurlan.hpjp.domain.repo

import kz.akanurlan.hpjp.domain.dao.BookEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface BookRepository : JpaRepository<BookEntity, UUID> {
}