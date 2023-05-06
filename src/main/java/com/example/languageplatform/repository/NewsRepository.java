package com.example.languageplatform.repository;

import com.example.languageplatform.dto.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {
    @Override
    List<News> findAll();
}
