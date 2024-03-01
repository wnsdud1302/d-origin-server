package com.junyeong.dorigin.Controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

import com.junyeong.dorigin.DTO.CategoryDTO;
import com.junyeong.dorigin.DTO.ProjectDTO;
import com.junyeong.dorigin.Model.Service.CategoryService;




@RestController
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/category/{name}")
    public List<ProjectDTO> getProjects(@PathVariable("name") String name) {
        List<ProjectDTO> projects = categoryService.getProjects(name);
        return projects;
    }

    @GetMapping("/getCategory")
    public List<CategoryDTO> getCategory() {
        return  categoryService.getCategories();
    }
    
    
}
