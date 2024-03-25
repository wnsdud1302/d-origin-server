package com.junyeong.dorigin.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.junyeong.dorigin.Model.Entity.Recruit;
import com.junyeong.dorigin.Model.Service.RecruitService;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@RequiredArgsConstructor
@RestController
public class RecruitController {
    private final RecruitService recruitService;
    
    @GetMapping("/recruit")
    public Page<Recruit> getRecruitPage(@RequestParam(required = false, defaultValue = "0", value = "page") int page,
                                        @RequestParam(required = false, defaultValue = "16", value = "size") int size) {
        return recruitService.getRecruitPage(page, size);
    }

    @GetMapping("/recruit/{title}")
    public Recruit getRecruit(@PathVariable("title") String title) {
        return recruitService.getRecruit(title);
    }

    @GetMapping("/recruit/list")
    public List<Recruit> getRecruits() {
        return recruitService.getAllRecruits();
    }

    @DeleteMapping("/recruit/delete")
    public void deleteRecruit(@RequestParam("title") String title) {
        recruitService.deleteRecruit(title);
    }

    @PutMapping("/recruit/modify")
    public Recruit modifyRecruit(@RequestParam("title") String title, @RequestBody Recruit entity) {
        return recruitService.modifyRecruit(title, entity);
    }

    @PostMapping("/recruit/create")
    public Recruit createRecruit(@RequestBody Recruit entity) {
        return recruitService.create(entity);
    }

}
