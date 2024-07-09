package com.scalex.openlibrary.controller;


import com.scalex.openlibrary.model.entity.Author;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.BookDetailsResponse;
import com.scalex.openlibrary.service.BookDetailsServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
 class BookControllerTest {
    @MockBean
    private BookDetailsServiceImpl bookDetailsService;


    @Test
    void getBooksInfoByISBNTest() throws Exception {

        BookDetailsRequest request = new BookDetailsRequest();
        request.setBook_isbn("1234567890");

        BookDetailsResponse response = BookDetailsResponse.builder()
                .book_isbn("1234567890")
                .title("lord of ring")
                .totalPages(50)
                .published_date("23-05-2023")
                .publishers(List.of("ScaleEx Tech","Open Library"))
                .build();
        when(bookDetailsService.getBooksInfoByISBN(any(BookDetailsRequest.class))).thenReturn(response);
    }
}
