package com.scalex.openlibrary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.BookDetailsResponse;
import com.scalex.openlibrary.model.response.DetailedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BookDetailsServiceImpl implements BookDetailsService{

    @Value("${GET_API}")
    private String getAPI;

    @Autowired
    RestTemplate restTemplate;

    BookDetailsResponse response;
    @Override
    public BookDetailsResponse getBooksInfoByISBN(BookDetailsRequest bookDetailsRequest) throws JsonProcessingException {
        StringBuilder builder = new StringBuilder(getAPI);
        String url = builder.append(bookDetailsRequest.getBook_isbn())
                .append(".json")
                .toString();
        ResponseEntity<String> exchange = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        String json = exchange.getBody();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            DetailedResponse info = objectMapper.readValue(json, DetailedResponse.class);
            System.out.println(info);
            response = BookDetailsResponse.builder()
                    .book_isbn(info.getIsbn_10().get(0))
                    .title(info.getTitle())
                    .totalPages(info.getNumber_of_pages())
                    .published_date(info.getPublish_date())
                    .publishers(info.getPublishers()).build();
            System.out.println(info);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
                return response;
    }
}
