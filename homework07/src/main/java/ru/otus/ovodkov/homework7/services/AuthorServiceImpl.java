package ru.otus.ovodkov.homework7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework7.domain.Author;
import ru.otus.ovodkov.homework7.domain.Book;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;
import ru.otus.ovodkov.homework7.repository.AuthorRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 10.04.2020
 * @see AuthorService
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    /**
     * @return Список авторов книг
     * @see AuthorService#getAuthors()
     */
    @Override
    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    /**
     * Получения списка книг указанного автора
     *
     * @param idAuthor Идентификатор автора
     * @return Список книг автора
     * @throws NoEntityException
     */
    @Override
    public Set<Book> getBooksAuthor(long idAuthor) throws NoEntityException {
        Author author = authorRepository
                .findByIdAuthor(idAuthor)
                .orElseThrow(() -> new NoEntityException(idAuthor, Author.class.getName()));
        return author.getBooks();
    }
}
