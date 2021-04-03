package ru.otus.ovodkov.homework6.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.ovodkov.homework6.dao.BookDao;
import ru.otus.ovodkov.homework6.dao.CommentDao;
import ru.otus.ovodkov.homework6.domain.Book;
import ru.otus.ovodkov.homework6.domain.Comment;
import ru.otus.ovodkov.homework6.exceptions.NoEntityException;

/**
 * @author Ovodkov Sergey on 07.04.2020
 * @see CommentService
 */
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDao commentRepository;
    private final BookDao bookRepository;


    /**
     * @param idBook Идентификатор книги
     * @param text   Добавляемый комментарий
     * @throws NoEntityException
     * @see CommentService#addCommentBook(long, String)
     */
    @Transactional
    @Override
    public Comment addCommentBook(long idBook, String text) throws NoEntityException {
        Book book = bookRepository
                .getByBookId(idBook)
                .orElseThrow(() -> new NoEntityException(idBook, Book.class.getName()));
        Comment comment = new Comment();
        comment.setCommentBook(text);
        Comment newComment = commentRepository.save(comment);
        newComment.setBook(book);
        return commentRepository.save(newComment);
    }
}
