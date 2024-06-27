package com.quoteGenerator.service;

import com.quoteGenerator.entity.AuthorEntity;


import java.util.List;

public interface AuthorService {

    AuthorEntity createAuthor (AuthorEntity authorEntity);
    AuthorEntity updateAuthor (AuthorEntity authorEntity);
    void deleteAuthor (Integer id);
    AuthorEntity getQuoteById( int id);

    List<AuthorEntity> getAllQuotes();
    AuthorEntity getRandomQuote();

}
