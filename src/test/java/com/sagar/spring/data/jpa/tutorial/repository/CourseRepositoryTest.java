package com.sagar.spring.data.jpa.tutorial.repository;

import com.sagar.spring.data.jpa.tutorial.entity.Course;
import com.sagar.spring.data.jpa.tutorial.entity.Student;
import com.sagar.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses = courseRepository.findAll();
        System.out.println(courses);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = new Teacher("Javarin","singh");
        Course course = new Course("Python",10,teacher);
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0,3);
        Pageable firstPageWithTwoRecords =
                PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPageWithTwoRecords).getContent();
        System.out.println("courses = "+courses );

        Long ele = courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();

        int totalPages = courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
        System.out.println("Total ele = "+ele);
        System.out.println("Total Pages = "+ totalPages);


    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle =
                PageRequest.of(0,2,
                        Sort.by("courseTitle"));
        Pageable sortByCreditDesc =
                PageRequest.of(0,2,
                        Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0,2,
                        Sort.by("courseTitle").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Sorted Courses ="+courses);

    }
    @Test
    public void saveCourseWithStudentAndTeacher(){
          Course course = new Course("AI",10,new Teacher("Ajay","Shinde"));
            Student student = new Student("Atharva","crua" ,"emails@new.com");

          course.addStudents(student);
          courseRepository.save(course);
    }

}