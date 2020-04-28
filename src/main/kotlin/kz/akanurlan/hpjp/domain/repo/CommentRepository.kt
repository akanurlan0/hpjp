package kz.akanurlan.hpjp.domain.repo

import kz.akanurlan.hpjp.domain.dao.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CommentRepository : JpaRepository<CommentEntity, UUID> {
}