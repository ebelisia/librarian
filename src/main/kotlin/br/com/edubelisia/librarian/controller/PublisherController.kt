package br.com.edubelisia.librarian.controller

import br.com.edubelisia.librarian.domain.model.Publisher
import br.com.edubelisia.librarian.service.PublisherService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/publishers")
class PublisherController(private val publisherService: PublisherService) {

    @GetMapping
    fun getAllPublishers(): List<Publisher> {
        return publisherService.getAllPublishers()
    }

    @GetMapping("/{id}")
    fun getPublisherById(@PathVariable id: Long): ResponseEntity<Publisher> {
        val publisher = publisherService.getPublisherById(id)
        return publisher?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createPublisher(@RequestBody publisher: Publisher): ResponseEntity<Publisher> {
        val createdPublisher = publisherService.createPublisher(publisher)
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPublisher)
    }

    @PutMapping("/{id}")
    fun updatePublisher(@PathVariable id: Long, @RequestBody updatedPublisher: Publisher): ResponseEntity<Publisher> {
        val updated = publisherService.updatePublisher(id, updatedPublisher)
        return updated?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deletePublisher(@PathVariable id: Long): ResponseEntity<Unit> {
        val deleted = publisherService.deletePublisher(id)
        return if (deleted) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
