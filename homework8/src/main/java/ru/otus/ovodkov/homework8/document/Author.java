package ru.otus.ovodkov.homework8.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Document(collection = "authors")
public class Author {

    @Id
    private ObjectId id;

    private String firstName;

    private String lastName;

    private List<Book> books;
}
