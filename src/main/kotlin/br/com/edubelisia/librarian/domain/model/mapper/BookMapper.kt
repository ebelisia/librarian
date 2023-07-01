package br.com.edubelisia.librarian.domain.model.mapper

import br.com.edubelisia.librarian.domain.model.Book
import br.com.edubelisia.librarian.domain.model.Publisher
import org.springframework.stereotype.Component

@Component
class BookMapper {

    fun updateBook(existingBook: Book, updatedBook: Book) {
        existingBook.title = updatedBook.title
        existingBook.author = updatedBook.author
        existingBook.publisher = updatedBook.publisher
        existingBook.publicationYear = updatedBook.publicationYear
    }

    fun patchBook(existingBook: Book,updatedAttributes: Map<String, Any>) {
        existingBook.run {
            updatedAttributes["title"]?.let { title = it as String }
            updatedAttributes["author"]?.let { author = it as String }
            updatedAttributes["publisher"]?.let { publisher = it as Publisher }
            updatedAttributes["publicationYear"]?.let { publicationYear = it as Int }
        }
    }


}
