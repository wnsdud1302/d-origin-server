package com.junyeong.dorigin.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import com.junyeong.dorigin.Model.Entity.News;

public interface NewsRepository extends JpaRepository<News, Long>{
    Optional<News> findBytitle(String title);
}
