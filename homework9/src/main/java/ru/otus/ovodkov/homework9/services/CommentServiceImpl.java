package ru.otus.ovodkov.homework9.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework9.exceptions.NoEntityException;
import ru.otus.ovodkov.homework9.model.Book;
import ru.otus.ovodkov.homework9.model.Comment;
import ru.otus.ovodkov.homework9.repository.BookRepository;
import ru.otus.ovodkov.homework9.repository.CommentRepository;

/**
 * Сервис работы с комментариями
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
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
