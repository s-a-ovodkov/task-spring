package ru.otus.ovodkov.homework11.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.ovodkov.homework11.dto.BookDto;

import java.util.List;

/**
 * Модель документа хранящая данные авторов книг
 *
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "authors")
public class Author {

    @Id
    private ObjectId id;

    /**
     * Имя автора
     */
    private String firstName;

    /**
     * Фамилия автора
     */
    private String lastName;

    /**
     * Список книг автора
     */
    private List<BookDto> books;
}