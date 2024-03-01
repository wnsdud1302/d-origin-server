package com.junyeong.dorigin.Model.Service;

import org.springframework.stereotype.Service;

import com.junyeong.dorigin.Model.Repository.CategoryRepository;
import com.junyeong.dorigin.DTO.CategoryDTO;
import com.junyeong.dorigin.DTO.ProjectDTO;
import com.junyeong.dorigin.Model.Entity.*;

import lombok.RequiredArgsConstructor;
import java.util.*;

@RequiredArgsConstructor
@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public Category create(String category){
        Optional<Category> query = categoryRepository.findByName(category);
        if(query.isPresent()){
            return query.get();
        }
        Category temp = new Category();
        temp.setName(category);
        categoryRepository.save(temp);
        return temp;

    }

    public Category getCategory(String category){
        Optional<Category> temp = categoryRepository.findByName(category);
        System.out.println(temp.get());
        if(!temp.isPresent()){
            return null;
        }
        return temp.get();
        
    }

    public List<CategoryDTO> getCategories(){
        List<Category> catlist = categoryRepository.findAll();
        List<CategoryDTO> catDtos = new ArrayList<CategoryDTO>();
        int length = catlist.size();
        for(int i = 0; i < length; i++){
            catDtos.add(new CategoryDTO(catlist.get(i).getName()));
        }

        return catDtos;
    }

    public List<ProjectDTO> getProjects(String category){
        Optional<Category> query = categoryRepository.findByName(category);
        if(query.isEmpty()){
            return null;
        }
        Category result = query.get();
        List<Project> prolist = result.getProjects();
        List<ProjectDTO> projectDTOs = new ArrayList<ProjectDTO>();
        int length = prolist.size();
        for(int i = 0; i < length; i++){
            projectDTOs.add(new ProjectDTO(prolist.get(i).getName(), prolist.get(i).getArea(), prolist.get(i).getScale(), prolist.get(i).getDescription()));
        }
        return projectDTOs;

    }

    @SuppressWarnings("null")
    public void deleteCategory(String category){
        Optional<Category> query = categoryRepository.findByName(category);
        if(query.isEmpty()){
            return;
        }
        Category result = query.get();
        categoryRepository.delete(result);
    }

    public void deleteAllCategories(){
        categoryRepository.deleteAll();
    }
    
}
