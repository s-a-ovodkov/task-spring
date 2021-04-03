package ru.otus.ovodkov.homework9.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework9.exceptions.NoEntityException;
import ru.otus.ovodkov.homework9.model.Book;
import ru.otus.ovodkov.homework9.model.Genre;
import ru.otus.ovodkov.homework9.repository.GenreRepository;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с жанрами книг
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
 */
@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Genre> getGenres() {
        return genreRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Set<Book> getBooksGenre(long idGenre) {
        return genreRepository
                .findByIdGenre(idGenre)
                .orElseThrow(() -> new NoEntityException(idGenre, Genre.class.getName()))
                .getBooks();
    }
}
