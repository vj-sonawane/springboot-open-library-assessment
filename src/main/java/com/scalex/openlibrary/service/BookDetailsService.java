package com.scalex.openlibrary.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scalex.openlibrary.model.request.BookDetailsRequest;
import com.scalex.openlibrary.model.response.BookDetailsResponse;

public interface BookDetailsService {


    BookDetailsResponse getBooksInfoByISBN(BookDetailsRequest bookDetailsRequest) throws JsonProcessingException;
}
