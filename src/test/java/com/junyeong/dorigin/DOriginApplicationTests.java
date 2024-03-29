package com.junyeong.dorigin;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.junyeong.dorigin.Model.Entity.Category;
import com.junyeong.dorigin.Model.Service.CategoryService;
import com.junyeong.dorigin.Model.Service.ProjectService;

@SpringBootTest
class DOriginApplicationTests {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProjectService projectService;


	@Test
	void contextLoads() {
		Category tmpCat = categoryService.create("근린생활시설");
		projectService.create("마곡지구 근린생활시설", 4349.66, "지하2층, 지상5층", "부연설명", tmpCat);
}

}
