package com.junyeong.dorigin.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyeong.dorigin.Model.Entity.Category;
import java.util.*;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
}
