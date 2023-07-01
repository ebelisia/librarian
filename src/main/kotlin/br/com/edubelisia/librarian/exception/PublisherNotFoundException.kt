package br.com.edubelisia.librarian.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PublisherNotFoundException(message: String) : RuntimeException(message)
