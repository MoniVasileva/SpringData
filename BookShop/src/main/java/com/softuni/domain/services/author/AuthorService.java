package com.softuni.domain.services.author;

import com.softuni.domain.entities.Author;

import java.time.LocalDate;
import java.util.List;


public interface AuthorService {

    void seedAuthors(List<Author> authors);

    boolean isDataSeeded();

    Author getRandomAuthor();

    List<Author> findDistinctByBooksBefore(LocalDate date);

    List<Author> findAllOrderByBooks();

}
