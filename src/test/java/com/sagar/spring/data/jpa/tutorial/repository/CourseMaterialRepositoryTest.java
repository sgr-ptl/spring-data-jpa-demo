package com.sagar.spring.data.jpa.tutorial.repository;

import com.sagar.spring.data.jpa.tutorial.entity.Course;
import com.sagar.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;


  /*  @Test
    public void saveCourseMaterial(){
        Course course = new Course("DS",6);
        CourseMaterial courseMaterial =
                new CourseMaterial("www.w3scools.com",course);
        repository.save(courseMaterial);
    }*/
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList =
                repository.findAll();
        System.out.println(courseMaterialList);

    }

}