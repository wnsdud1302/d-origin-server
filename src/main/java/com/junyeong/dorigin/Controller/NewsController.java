package com.junyeong.dorigin.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.junyeong.dorigin.Model.Entity.News;
import com.junyeong.dorigin.Model.Service.NewsService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping("/news/title/{title}")
    public News getNewsByTitle(@PathVariable("title") String title) {
        String temp = title.replace("-", " ");
        System.out.println(temp);
        return newsService.getNew(temp);
    }

    @GetMapping("/news/id/{id}")
    public News getNewsById(@PathVariable("id") Long id) {
        return newsService.getNewsById(id);
    }

    @GetMapping("/news")
    public Page<News> getNewsPage(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                        @RequestParam(required = false, defaultValue = "16", value = "size") int size) {
        return newsService.getNewsPage(page, size);
    }

    @PostMapping("/news/create")
    public News postMethodName(@RequestBody News entity) {
        News temp = newsService.create(entity);
        return temp;
    }
    
}
