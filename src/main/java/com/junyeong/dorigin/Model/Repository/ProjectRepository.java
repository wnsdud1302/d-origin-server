package com.junyeong.dorigin.Model.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyeong.dorigin.Model.Entity.Project;


public interface ProjectRepository extends JpaRepository<Project, Integer>{
    Optional<Project> findByName(String name);
}
