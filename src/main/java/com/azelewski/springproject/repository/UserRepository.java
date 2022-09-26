package com.azelewski.springproject.repository;

import com.azelewski.springproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
@Query("select u from User u where lower(u.username) like %:searchValue% " +
        "or lower(u.email) like %:searchValue% " +
        "or lower(u.firstName) like %:searchValue% " +
        "or lower(u.lastName) like %:searchValue%")
    List<User> findUsersBySearchValue(String searchValue);
}
