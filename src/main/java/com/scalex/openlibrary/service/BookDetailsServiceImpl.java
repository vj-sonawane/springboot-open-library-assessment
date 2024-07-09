package com.scalex.openlibrary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalex.openlibrary.exception.InvalidISBNException;
import com.scalex.openlibrary.model.entity.Author;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.AuthorResponse;
import com.scalex.openlibrary.model.response.BookDetailsResponse;
import com.scalex.openlibrary.model.response.DetailedResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BookDetailsServiceImpl implements BookDetailsService{

    @Value("${GET_API}")
    private String getAPI;

    @Value("${Base_URL}")
    private String baseURL;

    private final RestTemplate restTemplate;

    @Autowired
    public BookDetailsServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    String authorKey;

    @Override
    public BookDetailsResponse getBooksInfoByISBN(BookDetailsRequest bookDetailsRequest) throws JsonProcessingException, InvalidISBNException {
        log.info("Inside BookDetailsServiceImpl::getBooksInfoByISBN");
        log.debug("Book detail request: {}",bookDetailsRequest);
        StringBuilder builder = new StringBuilder(getAPI);
        String url = builder.append(bookDetailsRequest.getBook_isbn())
                .append(".json")
                .toString();
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = exchange.getBody();
        log.debug("ResponseBody getBooksInfoByISBN(): {}", json);
            ObjectMapper objectMapper = new ObjectMapper();
            DetailedResponse info = objectMapper.readValue(json, DetailedResponse.class);
        if (info != null) {
                return BookDetailsResponse.builder()
                        .book_isbn(info.getIsbn_10().get(0))
                        .title(info.getTitle())
                        .totalPages(info.getNumber_of_pages())
                        .published_date(info.getPublish_date())
                        .publishers(info.getPublishers()).build();
            }else {
                throw new InvalidISBNException("No book found with ISBN: "+info.getIsbn_10().get(0));
            }
    }
}
