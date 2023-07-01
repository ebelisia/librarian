package br.com.edubelisia.librarian.domain.model

import jakarta.persistence.*

@Entity
data class Publisher (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(unique = true)
    var name: String?
)

