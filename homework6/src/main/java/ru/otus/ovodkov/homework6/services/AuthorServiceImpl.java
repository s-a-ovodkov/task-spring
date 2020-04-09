package ru.otus.ovodkov.homework6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework6.dao.AuthorDao;
import ru.otus.ovodkov.homework6.domain.Author;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 07.04.2020
 * @see AuthorService
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorDao authorRepository;

    /**
     * @return Все авторы
     * @see AuthorService#getAuthors()
     */
    @Override
    public List<Author> getAuthors() {
        return authorRepository.getAllAuthor();
    }

    /**
     * @param idAuthor Идентификатор автора
     * @return Списко книг указаного автора
     * @throws NoEntityException
     * @see AuthorService#getBooksAuthor(long)
     */
    @Override
    public Set<Book> getBooksAuthor(long idAuthor) throws NoEntityException {
        Author author = authorRepository
                .getByIdAuthor(idAuthor)
                .orElseThrow(() -> new NoEntityException(idAuthor, Author.class.getName()));
        return author.getBooks();
    }
}
