package ru.otus.ovodkov.homework8.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.otus.ovodkov.homework8.dto.BookDto;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public String toString() {
        return "Author{" +
                " authorId = " + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", books = [" + books.stream().map(BookDto::toString).collect(Collectors.joining(", ")) + " ]" +
                " }";
    }
}
