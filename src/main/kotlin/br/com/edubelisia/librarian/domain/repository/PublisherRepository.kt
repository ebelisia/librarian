package br.com.edubelisia.librarian.domain.repository

import br.com.edubelisia.librarian.domain.model.Publisher
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PublisherRepository : JpaRepository<Publisher, Long> {
}