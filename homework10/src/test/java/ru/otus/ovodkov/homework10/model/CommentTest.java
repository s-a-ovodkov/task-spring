package ru.otus.ovodkov.homework10.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.ovodkov.homework10.entity.Book;
import ru.otus.ovodkov.homework10.entity.Comment;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ovodkov Sergey
 * created on 12.08.2020
 */
@DisplayName("Доменная модель Comment")
public class CommentTest {

    private static final long ID_COMMENT = 1L;
    private static final String COMMENT_BOOK = "Объемно и содержательно.";
    private static final Book BOOK = new Book();

    @DisplayName("корректно создается конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
        Comment comment = new Comment(ID_COMMENT, COMMENT_BOOK, BOOK);

        assertAll(
                () -> assertEquals(ID_COMMENT, comment.getIdComment()),
                () -> assertEquals(COMMENT_BOOK, comment.getCommentBook()),
                () -> assertNotNull(comment.getBook())
        );
    }
}
