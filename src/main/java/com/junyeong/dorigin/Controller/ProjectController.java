package com.junyeong.dorigin.Controller;

import java.util.*;

import org.springframework.web.bind.annotation.RestController;

import com.junyeong.dorigin.DTO.ProjectDTO;
import com.junyeong.dorigin.Model.Entity.Category;
import com.junyeong.dorigin.Model.Service.CategoryService;
import com.junyeong.dorigin.Model.Service.ProjectService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequiredArgsConstructor
public class ProjectController {
    
    private final ProjectService projectService;

    private final CategoryService categoryService;

    @GetMapping("/project/{name}")
    public ProjectDTO getProject(@PathVariable("name") String name) {
        return projectService.getProject(name);
    }

    @GetMapping("/project/all")
    public List<ProjectDTO> getProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/project")
    public Page<ProjectDTO> getProjectPage(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                        @RequestParam(required = false, defaultValue = "16", value = "size") int size) {
        return projectService.getProjectsPage(page, size);
    }

    @PostMapping("/project/create")
    public ProjectDTO createProject(@RequestBody ProjectDTO entity, @RequestParam("category") String category) {
        Category tempcCategory = categoryService.create(category);
        projectService.create(entity, tempcCategory);
        return entity;
    }
    
    
    
    
    
}
