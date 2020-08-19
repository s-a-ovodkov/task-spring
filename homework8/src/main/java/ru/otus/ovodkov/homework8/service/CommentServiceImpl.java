package ru.otus.ovodkov.homework8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.otus.ovodkov.homework8.document.Comment;
import ru.otus.ovodkov.homework8.exceptions.NoDocumentException;
import ru.otus.ovodkov.homework8.repository.CommentRepository;

import java.util.List;

/**
 * {@inheritDoc}
 *
 * @author Ovodkov Sergey
 * created on 19.08.2020
 */
@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Comment> getComments() {
        return commentRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteComment(String commentId) throws NoDocumentException {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new NoDocumentException(commentId, Comment.class.getName()));

        commentRepository.delete(comment);
    }
}
