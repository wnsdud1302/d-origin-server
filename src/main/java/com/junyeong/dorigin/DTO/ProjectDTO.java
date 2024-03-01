package com.junyeong.dorigin.DTO;

import lombok.Data;

@Data
public class ProjectDTO {
    String name;
    double area;
    String scale;
    String description;

    public ProjectDTO(String name, double area, String scale, String decription){
        this.name = name;
        this.area = area;
        this.scale = scale;
        this.description = decription;
    }
}
