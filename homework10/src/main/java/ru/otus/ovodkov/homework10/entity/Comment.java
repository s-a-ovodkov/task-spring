package ru.otus.ovodkov.homework10.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Модель комментария к книге
 *
 * @author Ovodkov Sergey
 * created on 11.08.2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "Comments")
public class Comment {

    /**
     * Идентификатор комментария
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComment")
    private long idComment;

    /**
     * Комментарий к книге
     */
    @Column(name = "commentBook")
    private String commentBook;

    /**
     * Книга к которой относится комментарий
     */
    @JsonManagedReference
    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idBook")
    private Book book;
}
