package ru.otus.ovodkov.homework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework8.document.Genre;
import ru.otus.ovodkov.homework8.repository.GenreRepository;

import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
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
    public void addGenres(String genreName) {
        Genre genre = new Genre();
        genre.setName(genreName);
        genreRepository.save(genre);
    }
}
