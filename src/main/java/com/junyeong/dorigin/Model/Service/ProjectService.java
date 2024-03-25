package com.junyeong.dorigin.Model.Service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.junyeong.dorigin.DTO.ProjectDTO;
import com.junyeong.dorigin.Model.Entity.Category;
import com.junyeong.dorigin.Model.Entity.Project;
import com.junyeong.dorigin.Model.Repository.ProjectRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectDTO create(ProjectDTO entity, Category category){
        Project project = new Project();
        project.setName(entity.getName());
        project.setArea(entity.getArea());
        project.setScale(entity.getScale());
        project.setDescription(entity.getDescription());
        project.setCategory(category);
        projectRepository.save(project);
        return entity;
    }

    public Project create(String name, double area, String scale, String decription,Category category){
        Project project = new Project();
        project.setName(name);
        project.setArea(area);
        project.setScale(scale);
        project.setDescription(decription);
        project.setCategory(category);
        projectRepository.save(project);
        return project;
    }


    public List<ProjectDTO> getAllProjects(){
        List<Project> query = projectRepository.findAll();
        List<ProjectDTO> temp = new ArrayList<ProjectDTO>();
        int length  = query.size();

        for(int i = 0; i < length; i++){
            temp.add(new ProjectDTO(query.get(i).getName(), query.get(i).getArea(), query.get(i).getScale(), query.get(i).getDescription()));
        }

        return temp;
        


    }

    public ProjectDTO getProject(String name){
        Optional<Project> prj = projectRepository.findByName(name);
        if(!prj.isPresent()){
            System.out.println("no project");
            return null;
        }
        Project temp = prj.get();
        return new ProjectDTO(temp.getName(), temp.getArea(), temp.getScale(), temp.getDescription());
    }

    public Page<ProjectDTO> getProjectsPage(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        Page<ProjectDTO> result = projectRepository.findAll(pageable).map(entity -> {
            ProjectDTO temp = new ProjectDTO(entity.getName(), entity.getArea(), entity.getScale(), entity.getDescription());
            return temp;
        });

        return result;
    }

    @SuppressWarnings("null")
    public void delete(String name){
        Optional<Project> prj = projectRepository.findByName(name);
        if(prj.isPresent()){
            projectRepository.delete(prj.get());
        }
    }

    public ProjectDTO modify(ProjectDTO entity, String name){
        Optional<Project> prj = projectRepository.findByName(name);
        if(prj.isPresent()){
            Project temp = prj.get();
            temp.setName(entity.getName());
            temp.setArea(entity.getArea());
            temp.setScale(entity.getScale());
            temp.setDescription(entity.getDescription());
            projectRepository.save(temp);
            return new ProjectDTO(temp.getName(), temp.getArea(), temp.getScale(), temp.getDescription());
        }
        return null;

    }

    public void deleteAllProjects(){
        projectRepository.deleteAll();
    }
}
