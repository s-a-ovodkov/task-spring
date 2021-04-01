package ru.otus.ovodkov.homework12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework12.entities.Comment;

/**
 * @author Ovodkov Sergey
 * created on 28.03.2021
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
