package com.scalex.openlibrary.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailsResponse {
    @JsonProperty("book_isbn")
    public String book_isbn;

    @JsonProperty("title")
    public String title;

    @JsonProperty("publishers")
    public List<String> publishers;

    @JsonProperty("authors")
    public List<Author> authors;

    @JsonProperty("totalPages")
    public Integer totalPages;

    @JsonProperty("published_date")
    public String published_date;

    @Data
    public class Author{
        @JsonProperty("authors")
        public String name;
    }
}
