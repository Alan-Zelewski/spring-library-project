package com.azelewski.springproject.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "book_availability")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookAvailability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long id;
    private Integer totalNumberOfBooks;
    private Integer booksBorrowed;
    private Integer booksAvailable;
    @OneToOne
    @MapsId
    @JoinColumn(name = "book_id")
    private Book book;
}
