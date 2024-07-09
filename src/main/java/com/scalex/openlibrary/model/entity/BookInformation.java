package com.scalex.openlibrary.model.entity;

import com.scalex.openlibrary.model.response.DetailedResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "book_information")
public class BookInformation  {
    @Id
    @Column(nullable = false, name="book_isbn")
    public String isbn_10;

    @Column(nullable = false, name="book_title")
    public String title;

    @Column(name="publishers")
    public List<String> publishers;

    @Column(name="book_totalPages")
    public Integer number_of_pages;

    @Column(name="book_published_date")
    public String publish_date;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "book_isbn")
    @Column(nullable = false, name="authors")
    public List<Author> authors;
}
