package com.azelewski.springproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String description;
    @OneToOne(mappedBy = "book",cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private BookAvailability bookAvailability;

    public void setBookAvailability(BookAvailability bookAvailability) {
        this.bookAvailability = bookAvailability;
        this.bookAvailability.setBook(this);
    }
}
