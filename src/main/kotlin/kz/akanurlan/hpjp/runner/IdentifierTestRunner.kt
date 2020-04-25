package kz.akanurlan.hpjp.runner

import kz.akanurlan.hpjp.domain.dao.BookEntity
import kz.akanurlan.hpjp.domain.dao.PersonEntity
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager


@Component
class IdentifierTestRunner() : CommandLineRunner {

    private val logger = KotlinLogging.logger {}

    @Autowired
    private lateinit var entityManager: EntityManager

    @Transactional // note #1:  BMT not working, switched to CMT
    override fun run(vararg args: String?) {

        entityManager.clear()

//        note #1:  BMT not working, switched to CMT
//        val transaction = entityManager.transaction
//        transaction.begin()

        val books = IntRange(1, 5)
            .map { BookEntity(name = "War and peace, part $it") }

        books.forEach { book ->
            entityManager.persist(book)
            logger.info { "book saved: ${book}" }
        }

        logger.debug { "flushing" }

        entityManager.flush()

        books.forEach { book ->
            logger.info { "book saved: ${book}" }
        }

        books.forEach { book ->
            entityManager.detach(book)
        }

//        note #1:
//        transaction.commit()

        logger.info { "---------------" }

        val persons = listOf(
            PersonEntity(name = "Lev Tolstoi"),
            PersonEntity(name = "Brandon Sanderson")
        )

        persons.forEach { person ->
            entityManager.persist(person)
            logger.info { "person saved: ${person}" }
        }

        logger.debug { "flushing" }

        entityManager.flush()

        persons.forEach { person ->
            logger.info { "person saved: ${person}" }
        }

        persons.forEach { person ->
            entityManager.detach(person)
        }
    }

}