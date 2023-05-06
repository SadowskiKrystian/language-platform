package com.example.languageplatform.service;

import com.example.languageplatform.dto.News;
import com.example.languageplatform.repository.NewsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    NewsRepository newsRepository;

    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> findAll(){
        return newsRepository.findAll();
    }
}
