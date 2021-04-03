package ru.otus.ovodkov.homework7.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework7.domain.Book;
import ru.otus.ovodkov.homework7.domain.Genre;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;
import ru.otus.ovodkov.homework7.repository.GenreRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 10.04.2020
 * @see GenreService
 */
@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    private GenreRepository genreRepository;

    /**
     * @return Список жанров
     * @see GenreService#getGenres()
     */
    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    /**
     * @param idGenre Идентификатор жанра
     * @return Список книг указанного жанра
     * @throws NoEntityException
     * @see GenreService#getBooksGenre(long)
     */
    @Override
    public Set<Book> getBooksGenre(long idGenre) throws NoEntityException {
        return genreRepository
                .findByIdGenre(idGenre)
                .orElseThrow(() -> new NoEntityException(idGenre, Genre.class.getName()))
                .getBooks();
    }
}
