package br.com.edubelisia.librarian.service

import br.com.edubelisia.librarian.domain.model.Publisher
import br.com.edubelisia.librarian.domain.repository.PublisherRepository
import org.springframework.stereotype.Service

@Service
class PublisherService(private val publisherRepository: PublisherRepository) {

    fun getAllPublishers(): List<Publisher> {
        return publisherRepository.findAll()
    }

    fun getPublisherById(id: Long): Publisher? {
        return publisherRepository.findById(id).orElse(null)
    }

    fun createPublisher(publisher: Publisher): Publisher {
        return publisherRepository.save(publisher)
    }

    fun updatePublisher(id: Long, updatedPublisher: Publisher): Publisher? {
        val existingPublisher = publisherRepository.findById(id).orElse(null)
        existingPublisher?.let {
            it.name = updatedPublisher.name ?: it.name
            return publisherRepository.save(it)
        }
        return null
    }

    fun deletePublisher(id: Long): Boolean {
        if (publisherRepository.existsById(id)) {
            publisherRepository.deleteById(id)
            return true
        }
        return false
    }
}
