package ru.otus.ovodkov.homework6.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Import;
import ru.otus.ovodkov.homework6.domain.Comment;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DAO для работы с комментариями")
@DataJpaTest
@Import(CommentDaoJpa.class)
public class CommentDaoJpaTest {

    @Autowired
    private CommentDaoJpa repositoryJpa;
    @Autowired
    private TestEntityManager em;

    private static final long ID_COMMENT = 1L;
    private static final int EXPECTED_COUNT_COMMENTS = 6;

    @DisplayName("возвращает комментарий по указанному идентификатору")
    @Test
    void shouldReturnExpectedComment() {
        Optional<Comment> optionalActualComment = repositoryJpa.getByIdComment(ID_COMMENT);
        Comment expected = em.find(Comment.class, ID_COMMENT);

        assertThat(optionalActualComment).isPresent().get()
                .isEqualToComparingFieldByField(expected);
    }

    @DisplayName("возвращает все комментарии")
    @Test
    void shouldReturnCorrectCommentListWithAllInfo() {
        List<Comment> actualList = repositoryJpa.getAllComments();

        assertThat(actualList).isNotNull().hasSize(EXPECTED_COUNT_COMMENTS)
                .allMatch(x -> !x.getCommentBook().equals(""))
                .allMatch(x -> x.getCommentBook() != null);
    }

    @DisplayName("удаляем выбранный комментарий")
    @Test
    void shouldDeleteComment() {
        repositoryJpa.delete(ID_COMMENT);
        long actual = repositoryJpa.getAllComments().size();

        assertEquals(EXPECTED_COUNT_COMMENTS - 1, actual);
    }
}
