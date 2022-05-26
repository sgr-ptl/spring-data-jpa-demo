package com.sagar.spring.data.jpa.tutorial.repository;

import com.sagar.spring.data.jpa.tutorial.entity.Gaurdian;
import com.sagar.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
      /*  Student student = new
                Student((long) 101,"sagar", "patil", "email@gmail.com",null);
        studentRepository.save(student);*/

    }
    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println(studentList);
    }
    @Test
    public void saveStudentWithGuardianDetails(){
      /*  Gaurdian gaurdian = new
                Gaurdian("hello","ha@email", "9887654321");
        Student student = new
                Student((long) 102,"gfagar", "khade patil", "gemail@gmail.com",gaurdian);

        studentRepository.save(student);*/

    }

    @Test
    public void printStudentByFirstname(){
        List<Student> studentList = studentRepository.findByFirstName("sagar");
        System.out.println(studentList);
    }
    @Test
    public void printStudentByFirstnameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("agar");
        System.out.println(studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> studentList = studentRepository.findByGaurdianName("RAJ");
        System.out.println(studentList);
    }

    @Test
    public void printStudentEmail(){
        System.out.println(studentRepository.getStudentByEmailAddress("email@gmail.com"));
    }

    @Test
    public void printStudentNamebyEmail(){
        System.out.println(studentRepository.getStudentFirstNameByEmailAddress("email@gmail.com"));
    }
    @Test
    public void printgetStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("email@gmail.com");
        System.out.println(student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamed(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamed("email@gmail.com");
        System.out.println(student);
    }

    @Test
    public void updateStudentNameByEamilAddress(){
        int x = studentRepository.updateStudentNameByEamilAddress("Ravindra","email@gmail.com");
        System.out.println(x);
    }
}