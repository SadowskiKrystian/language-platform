package com.example.languageplatform.api;

import com.example.languageplatform.dto.News;

import java.time.LocalDate;

public class NewsGetResponse {
    private String title;
    private String content;
    private LocalDate createDate;

    public NewsGetResponse() {
    }

    public NewsGetResponse(News news) {
        this.title = news.getTitle();
        this.content = news.getContent();
        this.createDate = news.getCreateDate();
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "NewsGetResponse{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
