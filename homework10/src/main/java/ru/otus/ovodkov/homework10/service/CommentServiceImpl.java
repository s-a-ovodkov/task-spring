package ru.otus.ovodkov.homework10.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Comment;
import ru.otus.ovodkov.homework10.exception.NoEntityException;
import ru.otus.ovodkov.homework10.repository.BookRepository;
import ru.otus.ovodkov.homework10.repository.CommentRepository;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
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
