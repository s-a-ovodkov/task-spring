package ru.otus.ovodkov.homework6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework6.dao.GenreDao;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Genre;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

import java.util.List;
import java.util.Set;

/**
 * @author Ovodkov Sergey on 07.04.2020
 * @see GenreService
 */
@RequiredArgsConstructor
@Service
public class GenreServiceImpl implements GenreService {

    private final GenreDao genreRepository;

    /**
     * @return Список жанров книг
     * @see GenreService#getGenres()
     */
    @Override
    public List<Genre> getGenres() {
        return genreRepository.getAllGenre();
    }

    /**
     * @param idGenre Идентификатор жанра
     * @return Список книг выбранного жанра
     * @throws NoEntityException
     * @see GenreService#getBooksGenre(long)
     */
    @Override
    public Set<Book> getBooksGenre(long idGenre) throws NoEntityException {
        Genre genre = genreRepository
                .getByIdGenre(idGenre)
                .orElseThrow(() -> new NoEntityException(idGenre, Genre.class.getName()));
        return genre.getBooks();
    }
}
