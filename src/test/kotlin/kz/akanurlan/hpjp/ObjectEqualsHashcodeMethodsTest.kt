package kz.akanurlan.hpjp

import kz.akanurlan.hpjp.domain.dao.BookEntity
import kz.akanurlan.hpjp.domain.dao.CompanyEntity
import kz.akanurlan.hpjp.domain.dao.PersonEntity
import kz.akanurlan.hpjp.domain.repo.BookRepository
import kz.akanurlan.hpjp.domain.repo.CompanyRepository
import kz.akanurlan.hpjp.domain.repo.PersonRepository
import mu.KotlinLogging
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ObjectEqualsHashcodeMethodsTest {

    private val logger = KotlinLogging.logger {}

    @Autowired
    private lateinit var bookRepository: BookRepository

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var companyRepository: CompanyRepository

    @Test
    fun addObjectIntoSet_BookEntity_setDoesContainObject() {

        val set = mutableSetOf<BookEntity>()

        val book = BookEntity(name = "Untitled book")
        logger.debug { "book: $book, hashcode: ${book.hashCode()}" }

        set.add(book)
        Assertions.assertTrue(set.contains(book))

        val saved = bookRepository.save(book)
        logger.debug { "book: $saved, hashcode: ${saved.hashCode()}" }

        Assertions.assertTrue(set.contains(saved))
    }

    @Test
    fun addObjectIntoSet_PersonEntity_setDoesNotContainObject() {

        val set = mutableSetOf<PersonEntity>()

        val person = PersonEntity(name = "Unknown author")
        logger.debug { "person: $person, hashcode: ${person.hashCode()}" }

        set.add(person)
        Assertions.assertTrue(set.contains(person))

        val saved = personRepository.save(person)
        logger.debug { "person: $person, hashcode: ${person.hashCode()}" }

        Assertions.assertFalse(set.contains(saved))
    }

    @Test
    fun addObjectIntoSet_CompanyEntity_setDoesContainObject() {

        val set = mutableSetOf<CompanyEntity>()

        val company = CompanyEntity(name = "Unknown company")
        logger.debug { "company: $company, id: ${company.id}, isNew: ${company.isNew}, hashcode: ${company.hashCode()}" }

        set.add(company)
        Assertions.assertTrue(set.contains(company))

        val saved = companyRepository.save(company)
        logger.debug { "company: $company, id: ${company.id}, isNew: ${company.isNew}, hashcode: ${company.hashCode()}" }

        Assertions.assertTrue(set.contains(saved))
    }
}