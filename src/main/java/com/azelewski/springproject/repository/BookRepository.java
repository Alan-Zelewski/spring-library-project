package com.azelewski.springproject.repository;

import com.azelewski.springproject.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("Select b from Book b where " +
            "b.title like %:searchValue% or " +
            "b.author like %:searchValue% or " +
            "b.isbn like %:searchValue%")
    List<Book> findBooksBySearchValue(@Param("searchValue") String searchValue);
}
