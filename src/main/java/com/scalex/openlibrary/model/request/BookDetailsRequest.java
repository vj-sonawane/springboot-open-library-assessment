package com.scalex.openlibrary.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDetailsRequest {
    @JsonProperty("book_isbn")
    @NotNull
    public String book_isbn;
}
