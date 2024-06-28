package com.quoteGenerator.service.impl;

import com.quoteGenerator.entity.AuthorEntity;
import com.quoteGenerator.repository.AuthorRepository;
import com.quoteGenerator.service.AuthorService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    // to save the author quotes
    public AuthorEntity createAuthor(AuthorEntity authorEntity) {
            return authorRepository.save(authorEntity);

        }

    @Override
    //to update the data for the existing data
    public AuthorEntity updateAuthor(AuthorEntity authorEntity) {
        AuthorEntity existingAuthor = authorRepository.findById(authorEntity.getId()).get();
        existingAuthor.setAuthorName(authorEntity.getAuthorName());
        existingAuthor.setQuote(authorEntity.getQuote());
        AuthorEntity updatedAuthor = authorRepository.save(existingAuthor);
        return updatedAuthor;
    }

    @Override
    //deleting  the author quotes
    public void deleteAuthor(Integer id) {
        authorRepository.deleteById(id);
    }


    @Override
    //find the quote by author id
    public AuthorEntity getQuoteById(int id) {

        AuthorEntity authorQuote =  authorRepository.findById(id).get();
        return authorQuote;
    }

    @Override
    //find all quotes
    public List<AuthorEntity> getAllQuotes() {
       return authorRepository.findAll();
    }

    @Override
    //find random quote
    public AuthorEntity getRandomQuote() {
        List<AuthorEntity> authorEntityList = authorRepository.findAll();
        Random random = new Random();
        if (authorEntityList.isEmpty())
            {
                return null;
            }
        int randomIndex =  random.nextInt(authorEntityList.size()); // gives random integer value
        return authorEntityList.get(randomIndex);
    }

    @Override
    public List<AuthorEntity> getByAuthor(String authorName) {
       return authorRepository.getQuoteByAuthorName(authorName);
    }

}
