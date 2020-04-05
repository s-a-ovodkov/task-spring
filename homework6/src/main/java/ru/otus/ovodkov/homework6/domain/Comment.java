package ru.otus.ovodkov.homework6.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
}
