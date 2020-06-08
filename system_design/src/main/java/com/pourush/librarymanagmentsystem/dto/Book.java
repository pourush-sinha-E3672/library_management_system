package com.pourush.librarymanagmentsystem.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by pourush.sinha on 23/03/19.
 */
@Data
public abstract class Book {
    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;
}
