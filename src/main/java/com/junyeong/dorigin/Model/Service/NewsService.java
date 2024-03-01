package com.junyeong.dorigin.Model.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.junyeong.dorigin.Model.Entity.News;
import com.junyeong.dorigin.Model.Repository.NewsRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NewsService {
    private final NewsRepository newsRepository;

    public News create(String title, String content){
        News temp = new News();
        temp.setTitle(title);
        temp.setContent(content);
        newsRepository.save(temp);
        return temp;
    }

    @SuppressWarnings("null")
    public News create(News entity){
        newsRepository.save(entity);
        return entity;
    }

    public News getNew(String title){
        if (newsRepository.findBytitle(title).isPresent()){
            return newsRepository.findBytitle(title).get();
        } else {
            return null;
        }
    }

    @SuppressWarnings("null")
    public News getNewsById(Long id){
        if (newsRepository.findById(id).isPresent()){
            return newsRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public List<News> getNews(){
        return newsRepository.findAll();
    }

    public Page<News> getNewsPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return newsRepository.findAll(pageable);
    }
    
    @SuppressWarnings("null")
    public void deleteNews(Long id){
        newsRepository.deleteById(id);
    }

    public void deleteAllNews(){
        newsRepository.deleteAll();
    }

}
