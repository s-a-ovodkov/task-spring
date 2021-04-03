package ru.otus.ovodkov.homework7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * Комментарий о книги
 *
 * @author Ovodkov Sergey on 10.04.2020
 */
@AllArgsConstructor
@NoArgsConstructor
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
     * Коментарий к книги
     */
    @Column(name = "commentBook")
    private String commentBook;

    /**
     * Книга к которой относится коментарий
     */
    @ManyToOne(targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idBook")
    private Book book;

    @Override
    public String toString() {
        return "Comment{" +
                " idComment=" + idComment +
                ", commentBook='" + commentBook + '\'' +
                " }";
    }
}
