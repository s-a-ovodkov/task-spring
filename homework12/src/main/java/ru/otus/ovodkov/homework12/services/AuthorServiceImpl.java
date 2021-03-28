package ru.otus.ovodkov.homework12.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework12.entities.Author;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.exceptions.NoEntityException;
import ru.otus.ovodkov.homework12.repositories.AuthorRepository;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с авторами книг
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Service
public class AuthorServiceImpl implements AuthorService {

  private final AuthorRepository authorRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public List<Author> getAuthors() {
    return authorRepository.findAll();
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Book> getBooksAuthor(long idAuthor) {
    Author author = authorRepository
        .findByIdAuthor(idAuthor)
        .orElseThrow(() -> new NoEntityException(idAuthor, Author.class.getName()));
    return author.getBooks();
  }
}
