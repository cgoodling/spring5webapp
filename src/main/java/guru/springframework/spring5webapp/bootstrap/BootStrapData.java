package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author1 = new Author("Michael", "Chrichton");
        Book jp = new Book("Jurassic Park", "12345");
        author1.getBooks().add(jp);
        jp.getAuthors().add(author1);

        authorRepository.save(author1);
        bookRepository.save(jp);

        Author author2 = new Author("Charles", "Dickens");
        Book cc = new Book("A Christmas Carol", "55456");
        cc.getAuthors().add(author2);
        author2.getBooks().add(cc);

        authorRepository.save(author2);
        bookRepository.save(cc);

        System.out.println("Started in BootStrap");
        System.out.println("Number of books: " + bookRepository.count());
    }
}
