package ru.otus.ovodkov.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Genre;
import ru.otus.ovodkov.homework10.exception.NoEntityException;
import ru.otus.ovodkov.homework10.repository.GenreRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
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
