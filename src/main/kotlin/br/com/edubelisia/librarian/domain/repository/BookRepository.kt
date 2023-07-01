package br.com.edubelisia.librarian.domain.repository

import br.com.edubelisia.librarian.domain.model.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}