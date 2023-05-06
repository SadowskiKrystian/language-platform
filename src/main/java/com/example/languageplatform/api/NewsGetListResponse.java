package com.example.languageplatform.api;

import java.util.List;

public class NewsGetListResponse {
    private List<NewsGetResponse> newses;

    public NewsGetListResponse(List<NewsGetResponse> newses) {
        this.newses = newses;
    }

    public List<NewsGetResponse> getNewses() {
        return newses;
    }
}
