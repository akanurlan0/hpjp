package kz.akanurlan.hpjp.runner

import kz.akanurlan.hpjp.domain.dao.BookEntity
import kz.akanurlan.hpjp.domain.dao.CommentEntity
import kz.akanurlan.hpjp.domain.repo.BookRepository
import mu.KotlinLogging
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class IdentifierTestRunner(
    private val bookRepository: BookRepository
) : CommandLineRunner {

    private val logger = KotlinLogging.logger {}

    @Transactional
    override fun run(vararg args: String?) {

        val book = BookEntity(
            name = "Untitled book"
        )

        val comment1 = CommentEntity(
            text = "Interesting book! 5 of 5"
        )

        val comment2 = CommentEntity(
            text = "Nah, don't like it"
        )

        book.comments.add(comment1)
        book.comments.add(comment2)

        val saved = bookRepository.save(book)

        //""2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996565|2|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|select * from information_schema.sequences|select * from information_schema.sequences
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996941|1|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|alter table if exists books_comments drop constraint if exists FK91847cp16ggotba9x8d3omdps|alter table if exists books_comments drop constraint if exists FK91847cp16ggotba9x8d3omdps
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996944|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|alter table if exists books_comments drop constraint if exists FKkp5ps7yi0dy0ylwhpvcwym92b|alter table if exists books_comments drop constraint if exists FKkp5ps7yi0dy0ylwhpvcwym92b
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996945|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|drop table if exists books cascade|drop table if exists books cascade
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996945|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|drop table if exists books_comments cascade|drop table if exists books_comments cascade
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996946|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|drop table if exists comments cascade|drop table if exists comments cascade
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996947|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|drop sequence if exists hibernate_sequence|drop sequence if exists hibernate_sequence
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996954|5|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|create sequence hibernate_sequence start 1 increment 1|create sequence hibernate_sequence start 1 increment 1
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996961|6|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|create table books (id int8 not null, name varchar(255), primary key (id))|create table books (id int8 not null, name varchar(255), primary key (id))
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996963|1|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|create table books_comments (book_entity_id int8 not null, comments_id int8 not null)|create table books_comments (book_entity_id int8 not null, comments_id int8 not null)
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996970|6|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|create table comments (id int8 not null, text varchar(255), primary key (id))|create table comments (id int8 not null, text varchar(255), primary key (id))
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996976|5|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|alter table if exists books_comments add constraint UK_3odoeetwfl5noqbrp3wwvffcl unique (comments_id)|alter table if exists books_comments add constraint UK_3odoeetwfl5noqbrp3wwvffcl unique (comments_id)
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996979|2|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|alter table if exists books_comments add constraint FK91847cp16ggotba9x8d3omdps foreign key (comments_id) references comments|alter table if exists books_comments add constraint FK91847cp16ggotba9x8d3omdps foreign key (comments_id) references comments
        //"2020-04-28 23:46:36 [main] INFO  p6spy - 1588095996981|2|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|alter table if exists books_comments add constraint FKkp5ps7yi0dy0ylwhpvcwym92b foreign key (book_entity_id) references books|alter table if exists books_comments add constraint FKkp5ps7yi0dy0ylwhpvcwym92b foreign key (book_entity_id) references books
        //"2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998251|4|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|select nextval ('hibernate_sequence')|select nextval ('hibernate_sequence')
        //"2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998268|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|select nextval ('hibernate_sequence')|select nextval ('hibernate_sequence')
        //"2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998269|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|select nextval ('hibernate_sequence')|select nextval ('hibernate_sequence')
        //""2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998285|1|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|insert into books (name, id) values (?, ?)|insert into books (name, id) values ('Untitled book', 1)
        //""2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998286|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|insert into comments (text, id) values (?, ?)|insert into comments (text, id) values ('Interesting book! 5 of 5', 2)
        //""2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998287|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|insert into comments (text, id) values (?, ?)|insert into comments (text, id) values ('Nah, don''t like it', 3)
        //""2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998291|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|insert into books_comments (book_entity_id, comments_id) values (?, ?)|insert into books_comments (book_entity_id, comments_id) values (1, 2)
        //""2020-04-28 23:46:38 [main] INFO  p6spy - 1588095998291|0|statement|connection 0|url jdbc:p6spy:postgresql://localhost:5432/goodreads?createDatabaseIfNotExist=true|insert into books_comments (book_entity_id, comments_id) values (?, ?)|insert into books_comments (book_entity_id, comments_id) values (1, 3)
    }

}