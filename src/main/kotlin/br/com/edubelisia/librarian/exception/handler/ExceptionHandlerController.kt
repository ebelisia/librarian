package br.com.edubelisia.librarian.exception.handler

import br.com.edubelisia.librarian.exception.BookNotFoundException
import br.com.edubelisia.librarian.exception.PublisherNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerController {

    @ExceptionHandler(PublisherNotFoundException::class)
    fun handlePublisherNotFoundException(e: PublisherNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.NOT_FOUND, e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse)
    }

    @ExceptionHandler(BookNotFoundException::class)
    fun handlePublisherNotFoundException(e: BookNotFoundException): ResponseEntity<ErrorResponse> {
        val errorResponse = ErrorResponse(HttpStatus.NOT_FOUND, e.message)
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse)
    }

    data class ErrorResponse(val status: HttpStatus, val message: String?)
}
