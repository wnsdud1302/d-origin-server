package com.junyeong.dorigin.Model.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.junyeong.dorigin.Model.Entity.Recruit;
import com.junyeong.dorigin.Model.Repository.RecruitRepository;

import lombok.RequiredArgsConstructor;

import java.util.*;

@RequiredArgsConstructor
@Service
public class RecruitService {
    private final RecruitRepository recruitRepository;

    @SuppressWarnings("null")
    public Recruit create(Recruit entity){
        recruitRepository.save(entity);
        return entity;
    }

    public List<Recruit> getAllRecruits(){
        return recruitRepository.findAll();
    }

    public Page<Recruit> getRecruitPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<Recruit> query = recruitRepository.findAll(pageable);
        return query;
    }

    public Recruit getRecruit(String title){
        return recruitRepository.findByTitle(title);
    }

    @SuppressWarnings("null")
    public void deleteRecruit(String title){
        Optional<Recruit> temp = Optional.ofNullable(recruitRepository.findByTitle(title));
        if(temp.isPresent()){
            recruitRepository.delete(temp.get());
        }
    }

    public Recruit modifyRecruit(String title, Recruit entity){
        Recruit temp = recruitRepository.findByTitle(title);
        temp.setTitle(entity.getTitle());
        temp.setContent(entity.getContent());
        recruitRepository.save(temp);
        return temp;
    }
}
