package com.junyeong.dorigin.DTO;

import lombok.Data;

@Data
public class CategoryDTO {
    private String name;
    public CategoryDTO(String name){
        this.name = name;
    }
}
