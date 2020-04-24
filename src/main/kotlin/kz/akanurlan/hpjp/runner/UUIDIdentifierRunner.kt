package kz.akanurlan.hpjp.runner

import kz.akanurlan.hpjp.domain.dao.BookEntity
import kz.akanurlan.hpjp.domain.repo.BookRepository
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import java.util.UUID

@Component
class UUIDIdentifierRunner(
    private val bookRepository: BookRepository
) : CommandLineRunner {

    private val logger = KotlinLogging.logger {}

    override fun run(vararg args: String?) {

        try {
            bookRepository.save(
                BookEntity()
            )
        } catch (ex: Exception) {
            logger.error(ex) { "cannot save without assigned id" }
        }

        bookRepository.save(
            BookEntity(id = UUID.randomUUID())
        )

    }

}