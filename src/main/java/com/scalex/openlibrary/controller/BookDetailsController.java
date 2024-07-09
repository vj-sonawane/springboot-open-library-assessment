package com.scalex.openlibrary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scalex.openlibrary.model.entity.BookInformation;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.BookDetailsResponse;
import com.scalex.openlibrary.service.BookDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookDetailsController {

    private final BookDetailsService bookDetailsService;

    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<BookDetailsResponse> getBooksInfoByISBN(@RequestBody BookDetailsRequest bookDetailsRequest) throws JsonProcessingException {
        BookDetailsResponse info = bookDetailsService.getBooksInfoByISBN(bookDetailsRequest);
        return new ResponseEntity<>(info, HttpStatus.OK);
    }









}
