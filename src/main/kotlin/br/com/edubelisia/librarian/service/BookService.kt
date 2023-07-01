package br.com.edubelisia.librarian.service

import br.com.edubelisia.librarian.constants.ErrorMessages
import br.com.edubelisia.librarian.domain.model.Book
import br.com.edubelisia.librarian.domain.model.mapper.BookMapper
import br.com.edubelisia.librarian.domain.repository.BookRepository
import br.com.edubelisia.librarian.domain.repository.PublisherRepository
import br.com.edubelisia.librarian.exception.BookNotFoundException
import org.springframework.stereotype.Service

@Service
class BookService (
    private val bookRepository: BookRepository,
    private val publisherRepository: PublisherRepository,
    private val bookMapper: BookMapper
    ) {

    fun getAllBooks(): List<Book> {
        return bookRepository.findAll()
    }

    fun getBookById(id: Long): Book? {
        return bookRepository.findById(id)
            .orElseThrow { BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.format(id)) }
    }

    fun createBook(book: Book): Book {
        val publisher = publisherRepository.findById(book.publisher.id)
            .orElseThrow { BookNotFoundException(ErrorMessages.PUBLISHER_NOT_FOUND.format(book.publisher.id)) }
        book.publisher = publisher
        return bookRepository.save(book)
    }

    fun updateBook(bookId: Long, updatedBook: Book): Book {
        val existingBook = bookRepository.findById(bookId)
            .orElseThrow { BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.format(bookId)) }
        bookMapper.updateBook(existingBook, updatedBook)
        return bookRepository.save(existingBook)
    }

    fun patchBook(bookId: Long, updatedAttributes: Map<String, Any>): Book {
        val existingBook = bookRepository.findById(bookId)
            .orElseThrow { BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.format(bookId)) }
        bookMapper.patchBook(existingBook, updatedAttributes)
        return bookRepository.save(existingBook)
    }

    fun deleteBook(id: Long) {
        bookRepository.existsById(id)
            .takeIf { it }
            ?.let { bookRepository.deleteById(id) }
            ?: throw BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND.format(id))
    }

}