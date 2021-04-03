package ru.otus.ovodkov.homework9.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework9.model.Comment;

/**
 * Репозиторий комментариев
 *
 * @author Ovodkov Sergey
 * created on 26.04.2020
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
