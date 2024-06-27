package com.quoteGenerator.entity;


import jakarta.persistence.*;


@Entity
@Table
public class AuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Author_Name" ,nullable = false)
    private String authorName;
    @Column (name = "Quote", nullable = false)
    private String quote;

    public AuthorEntity(int id, String authorName, String quote) {
        this.id = id;
        this.authorName = authorName;
        this.quote = quote;
    }

    public AuthorEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}
