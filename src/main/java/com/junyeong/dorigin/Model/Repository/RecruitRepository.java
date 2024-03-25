package com.junyeong.dorigin.Model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.junyeong.dorigin.Model.Entity.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Long>{
    public Recruit findByTitle(String title);

    public void deleteByTitle(String title);
    
}
