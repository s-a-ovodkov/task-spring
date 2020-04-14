package ru.otus.ovodkov.homework7.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework7.domain.Book;
import ru.otus.ovodkov.homework7.domain.Comment;
import ru.otus.ovodkov.homework7.exceptions.NoEntityException;
import ru.otus.ovodkov.homework7.repository.BookRepository;
import ru.otus.ovodkov.homework7.repository.CommentRepository;

import java.util.Set;

/**
 * @author Ovodkov Sergey on 11.04.2020
 * @see CommentService
 */
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final BookRepository bookRepository;
    private final CommentRepository commentRepository;

    /**
     * @param idBook Идентификатор книги
     * @param text   Добавляемый комментарий
     * @return Обновленный комментарий
     * @throws NoEntityException
     * @see CommentService#addCommentBook(long, String)
     */
    @Override
    public Comment addCommentBook(long idBook, String text) throws NoEntityException {
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
