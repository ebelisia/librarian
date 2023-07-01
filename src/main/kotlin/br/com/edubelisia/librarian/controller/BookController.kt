package br.com.edubelisia.librarian.controller

import br.com.edubelisia.librarian.domain.model.Book
import br.com.edubelisia.librarian.service.BookService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController (private val bookService: BookService) {

    @GetMapping
    fun getAllBooks(): ResponseEntity<List<Book>> {
        val books = bookService.getAllBooks()
        return ResponseEntity.ok(books)
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable id: Long): ResponseEntity<Book> {
        val book = bookService.getBookById(id)
        return ResponseEntity.ok(book)
    }

    @PostMapping
    fun createBook(@RequestBody book: Book): ResponseEntity<Book> {
            val createdBook = bookService.createBook(book)
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBook)
    }

    @PutMapping("/{id}")
    fun updateBook(@PathVariable id: Long, @RequestBody book: Book): ResponseEntity<Book> {
        val updatedBook = bookService.updateBook(id, book)
        return ResponseEntity.ok(updatedBook)
    }

    @PatchMapping("/{id}")
    fun patchBook(@PathVariable id: Long, @RequestBody updatedAttributes: Map<String, Any>): ResponseEntity<Book> {
        val updatedBook = bookService.patchBook(id, updatedAttributes)
        return ResponseEntity.ok(updatedBook)
    }

    @DeleteMapping("/{id}")
    fun deleteBook(@PathVariable id: Long): ResponseEntity<Unit> {
        bookService.deleteBook(id)
        return ResponseEntity.noContent().build()
    }

}