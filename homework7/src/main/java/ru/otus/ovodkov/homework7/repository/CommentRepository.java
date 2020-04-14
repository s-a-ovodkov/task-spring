package ru.otus.ovodkov.homework7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.otus.ovodkov.homework7.domain.Comment;

/**
 * Репозиторий комментариев
 *
 * @author Ovodkov Sergey on 10.04.2020
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
