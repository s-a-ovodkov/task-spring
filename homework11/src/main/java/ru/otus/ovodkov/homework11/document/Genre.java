package ru.otus.ovodkov.homework11.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Документ жанров книг
 *
 * @author Ovodkov Sergey
 * created on 15.09.2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document(collection = "genres")
public class Genre {

    @Id
    private ObjectId id;

    private String name;
}
