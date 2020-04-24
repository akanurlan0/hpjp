package kz.akanurlan.hpjp.runner

import kz.akanurlan.hpjp.domain.dao.BookEntity
import kz.akanurlan.hpjp.domain.repo.BookRepository
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class UUIDIdentifierRunner(
    private val bookRepository: BookRepository
) : CommandLineRunner {

    private val logger = KotlinLogging.logger {}

    override fun run(vararg args: String?) {

        for (i in 1..100) {
            bookRepository.save(
                BookEntity()
            )
        }

        logger.info { "--------------" }

        val collection = IntRange(1, 100).map { BookEntity() }

        bookRepository.saveAll(collection)
    }

}