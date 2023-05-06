package com.example.languageplatform.endpoint;

import com.example.languageplatform.api.LoginGetRequest;
import com.example.languageplatform.api.NewsGetListResponse;
import com.example.languageplatform.api.NewsGetResponse;
import com.example.languageplatform.auth.UserRole;
import com.example.languageplatform.dto.Login;

import com.example.languageplatform.dto.News;
import com.example.languageplatform.dto.Profile;
import com.example.languageplatform.service.LoginService;
import com.example.languageplatform.service.NewsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class LanguagePlatformEndPoint {
    private NewsService newsService;
    private LoginService loginService;

    public LanguagePlatformEndPoint(NewsService newsService, LoginService loginService) {
        this.newsService = newsService;
        this.loginService = loginService;
    }

    @GetMapping("/get-news")
    public NewsGetListResponse getNews() {
        List<News> newses = newsService.findAll();
        return new NewsGetListResponse(newsesToResponse(newses));
    }
    @PostMapping("/quest/add-user")
    public void addUser(@RequestBody LoginGetRequest loginGetRequest){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = loginGetRequest.getPassword();
        String encodedPasword = encoder.encode(rawPassword);
        loginService.create(new Login(loginGetRequest.getEmail(), encodedPasword, new Profile(loginGetRequest.getFirstName(), loginGetRequest.getSurname(), loginGetRequest.getCity(), loginGetRequest.getPhoneNumber()), UserRole.QUEST.getCodeWithRole()));
    }

    private List<NewsGetResponse> newsesToResponse(List<News> newses) {
        List<NewsGetResponse> list = new ArrayList<>();
        for (News news : newses) {
            list.add(new NewsGetResponse(news));
        }
        return list;

    }

}
