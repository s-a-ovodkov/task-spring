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
import ru.otus.ovodkov.homework12.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@DisplayName("Сервис работы с авторами книг")
@SpringBootTest
class AuthorServiceTest {

  @Mock
  private AuthorRepository authorRepository;
  @InjectMocks
  private AuthorServiceImpl authorService;

  private static final String EXPECTED_LAST_NAME = "Албахари";
  private static final String EXPECTED_FIRST_NAME = "Бен";
  private static final String EXPECTED_TITLE_BOOK = "C# 6.0. Справочник";
  private static final int EXPECTED_EDITION = 6;
  private static final int EXPECTED_YEAR_PUBLISHING = 2017;
  private static final int EXPECTED_COUNT = 1;
  private static final int ID_AUTHOR = 1;

  @BeforeEach
  void setUp() {
    Book expectedBook = new Book();
    expectedBook.setTitleBook(EXPECTED_TITLE_BOOK);
    expectedBook.setEdition(EXPECTED_EDITION);
    expectedBook.setYearPublishing(EXPECTED_YEAR_PUBLISHING);
    expectedBook.setAuthors(Set.of(new Author()));
    expectedBook.setComments(Set.of(new Comment()));
    expectedBook.setGenres(Set.of(new Genre()));

    Author expectedAuthor = new Author();
    expectedAuthor.setFirstName(EXPECTED_FIRST_NAME);
    expectedAuthor.setLastName(EXPECTED_LAST_NAME);
    expectedAuthor.setBooks(Set.of(expectedBook));

    when(authorRepository.findAll()).thenReturn(List.of(expectedAuthor));
    when(authorRepository.findByIdAuthor(ID_AUTHOR)).thenReturn(Optional.of(expectedAuthor));
  }

  @DisplayName("возвращает всех авторов")
  @Test
  void shouldReturnCorrectAuthorListWithAllInfo() {
    List<Author> authors = authorService.getAuthors();

    assertThat(authors).isNotNull().hasSize(EXPECTED_COUNT)
        .allMatch(x -> x.getFirstName().equals(EXPECTED_FIRST_NAME))
        .allMatch(x -> x.getLastName().equals(EXPECTED_LAST_NAME))
        .allMatch(x -> x.getBooks() != null && x.getBooks().size() > 0);
  }

  @DisplayName("возвращает книги указанного автора")
  @Test
  void shouldReturnCorrectBooksListAuthor() throws NoEntityException {
    Set<Book> books = authorService.getBooksAuthor(ID_AUTHOR);

    assertThat(books).isNotNull().hasSize(EXPECTED_COUNT)
        .allMatch(x -> x.getTitleBook().equals(EXPECTED_TITLE_BOOK))
        .allMatch(x -> x.getEdition() == EXPECTED_EDITION)
        .allMatch(x -> x.getYearPublishing() == EXPECTED_YEAR_PUBLISHING)
        .allMatch(x -> x.getAuthors() != null && x.getAuthors().size() > 0)
        .allMatch(x -> x.getComments() != null && x.getComments().size() > 0)
        .allMatch(x -> x.getGenres() != null && x.getGenres().size() > 0);
  }
}
