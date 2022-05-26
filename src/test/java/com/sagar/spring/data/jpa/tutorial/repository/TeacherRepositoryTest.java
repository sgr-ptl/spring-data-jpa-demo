package com.sagar.spring.data.jpa.tutorial.repository;

import com.sagar.spring.data.jpa.tutorial.entity.Course;
import com.sagar.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        List<Course> courses = new ArrayList<>();
        /*courses.add(new Course("Physics",8));
        courses.add(new Course("Maths",7));*/

        Teacher teacher = new Teacher("Himani","Patil");
        teacherRepository.save(teacher);
    }

}