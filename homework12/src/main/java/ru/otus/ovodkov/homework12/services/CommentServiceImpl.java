package ru.otus.ovodkov.homework12.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework12.entities.Book;
import ru.otus.ovodkov.homework12.entities.Comment;
import ru.otus.ovodkov.homework12.exceptions.NoEntityException;
import ru.otus.ovodkov.homework12.repositories.BookRepository;
import ru.otus.ovodkov.homework12.repositories.CommentRepository;

/**
 * Сервис работы с комментариями
 *
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

  private final BookRepository bookRepository;
  private final CommentRepository commentRepository;

  /**
   * {@inheritDoc}
   */
  @Override
  public Comment addCommentBook(long idBook, String text) {
    Book book = bookRepository
        .findByIdBook(idBook)
        .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
    Comment comment = new Comment();
    comment.setCommentBook(text);
    Comment newComment = commentRepository.save(comment);
    newComment.setBook(book);
    return commentRepository.save(newComment);
  }
}
