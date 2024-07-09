package com.scalex.openlibrary.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scalex.openlibrary.exception.InvalidISBNException;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.BookDetailsResponse;
import com.scalex.openlibrary.model.response.ErrorResponse;
import com.scalex.openlibrary.service.BookDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class BookDetailsController {

    @Value("${ErrorMsg}")
    private String errorMsg;
    private final BookDetailsService bookDetailsService;

    @Autowired
    public BookDetailsController(BookDetailsService bookDetailsService) {
        this.bookDetailsService = bookDetailsService;
    }

    @GetMapping(value = "/books", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> getBooksInfoByISBN(@RequestBody BookDetailsRequest bookDetailsRequest) {
        try {
            BookDetailsResponse info = bookDetailsService.getBooksInfoByISBN(bookDetailsRequest);
            return new ResponseEntity<>(info, HttpStatus.OK);
        } catch (JsonProcessingException | InvalidISBNException ex) {
            log.error("Exception while getting book information: "+ex.getMessage());
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .message(errorMsg)
                    .details(ex.getMessage())
                    .build();
            return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }









}
