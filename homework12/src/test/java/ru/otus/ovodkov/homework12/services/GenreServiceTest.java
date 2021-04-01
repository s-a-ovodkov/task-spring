package ru.otus.ovodkov.homework12.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.otus.ovodkov.homework12.entities.Author;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.entities.Comment;
import ru.otus.ovodkov.homework12.entities.Genre;
import ru.otus.ovodkov.homework12.exceptions.NoEntityException;
import ru.otus.ovodkov.homework12.repositories.GenreRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@DisplayName("Сервис работы с жанрами книг")
@SpringBootTest
class GenreServiceTest {

  @Mock
  private GenreRepository genreRepository;
  @InjectMocks
  private GenreServiceImpl genreService;

  private static final String EXPECTED_TITLE_BOOK = "C# 6.0. Справочник";
  private static final int EXPECTED_EDITION = 6;
  private static final int EXPECTED_YEAR_PUBLISHING = 2017;
  private static final String EXPECTED_NAME_GENRE = "C#";
  private static final String EXPECTED_DESCRIPTION_GENRE = "Тоже не плохой язык программирования";
  private static final int EXPECTED_COUNT = 1;
  private static final long ID_GENRE = 1L;

  @BeforeEach
  void setUp() {
    Book expectedBook = new Book();
    expectedBook.setTitleBook(EXPECTED_TITLE_BOOK);
    expectedBook.setEdition(EXPECTED_EDITION);
    expectedBook.setYearPublishing(EXPECTED_YEAR_PUBLISHING);
    expectedBook.setAuthors(Set.of(new Author()));
    expectedBook.setComments(Set.of(new Comment()));
    expectedBook.setGenres(Set.of(new Genre()));

    Genre expectedGenre = new Genre();
    expectedGenre.setNameGenre(EXPECTED_NAME_GENRE);
    expectedGenre.setDescriptionGenre(EXPECTED_DESCRIPTION_GENRE);
    expectedGenre.setBooks(Set.of(expectedBook));

    when(genreRepository.findAll()).thenReturn(List.of(expectedGenre));
    when(genreRepository.findByIdGenre(ID_GENRE)).thenReturn(Optional.of(expectedGenre));
  }

  @DisplayName("возвращает список жанров")
  @Test
  void shouldReturnCorrectGenreListWithAllInfo() {
    List<Genre> genres = genreService.getGenres();

    assertThat(genres).isNotNull().hasSize(EXPECTED_COUNT)
        .allMatch(x -> x.getNameGenre().equals(EXPECTED_NAME_GENRE))
        .allMatch(x -> x.getDescriptionGenre().equals(EXPECTED_DESCRIPTION_GENRE))
        .allMatch(x -> x.getBooks() != null && x.getBooks().size() > 0);
  }

  @DisplayName("возвращает список книг указанного жанра")
  @Test
  void shouldReturnCorrectBooksListGenre() throws NoEntityException {
    Set<Book> books = genreService.getBooksGenre(ID_GENRE);

    assertThat(books).isNotNull().hasSize(EXPECTED_COUNT)
        .allMatch(x -> x.getTitleBook().equals(EXPECTED_TITLE_BOOK))
        .allMatch(x -> x.getEdition() == EXPECTED_EDITION)
        .allMatch(x -> x.getYearPublishing() == EXPECTED_YEAR_PUBLISHING)
        .allMatch(x -> x.getAuthors() != null && x.getAuthors().size() > 0)
        .allMatch(x -> x.getComments() != null && x.getComments().size() > 0)
        .allMatch(x -> x.getGenres() != null && x.getGenres().size() > 0);
  }
}
