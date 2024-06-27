package com.quoteGenerator.controller;

import com.quoteGenerator.entity.AuthorEntity;
import com.quoteGenerator.service.AuthorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AuthorQuote")
public class AuthorController {
    private AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //http://localhost:8080/AuthorQuote
    @PostMapping
    public ResponseEntity<AuthorEntity> createAuthor (@RequestBody AuthorEntity authorEntity){
          AuthorEntity savedAuthor =  authorService.createAuthor(authorEntity);
          return new ResponseEntity<>(savedAuthor, HttpStatus.CREATED);
    }
    //http://localhost:8080/AuthorQuote/1
    @PutMapping("/{id}")
    public ResponseEntity<AuthorEntity> updateAuthor (@RequestBody AuthorEntity authorEntity,
                                                      @PathVariable int id){
        //authorEntity.setId(id);
        AuthorEntity updatedAuthor = authorService.updateAuthor(authorEntity);
        return new ResponseEntity<>(updatedAuthor, HttpStatus.OK);
    }

    //http://localhost:8080/AuthorQuote/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable int id){
            authorService.deleteAuthor(id);
            return new ResponseEntity<>("Author information deleted successfully", HttpStatus.OK);
    }

    //http://localhost:8080/AuthorQuote/1
    @GetMapping("/{id}")
    public ResponseEntity<AuthorEntity> getQuoteById(@PathVariable int id){

           AuthorEntity getQuote = authorService.getQuoteById(id);
           return new ResponseEntity<>(getQuote, HttpStatus.OK);
    }

    //http://localhost:8080/AuthorQuote/allQuotes
    @GetMapping("/allQuotes")
    public ResponseEntity<List<AuthorEntity>> getAllQuotes (){
        List<AuthorEntity> allQuotes = authorService.getAllQuotes();
        return new ResponseEntity<>(allQuotes, HttpStatus.OK);
    }

    //http://localhost:8080/AuthorQuote/random
    @GetMapping("/random")
    public ResponseEntity<AuthorEntity> getRandomQuotes(){
       AuthorEntity randomQuotes =  authorService.getRandomQuote();
        return new ResponseEntity<>(randomQuotes, HttpStatus.OK);
    }

    }



