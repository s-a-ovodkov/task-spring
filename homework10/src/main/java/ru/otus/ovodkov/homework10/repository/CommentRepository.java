package ru.otus.ovodkov.homework10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework10.entity.Comment;

/**
 * Репозиторий комментариев к книгам
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
