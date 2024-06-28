package com.quoteGenerator.repository;

import com.quoteGenerator.entity.AuthorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository <AuthorEntity, Integer> {

    List<AuthorEntity> getQuoteByAuthorName(String authorName);
}
