package com.sagar.spring.data.jpa.tutorial.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Course {

    @Id
    @SequenceGenerator(
            name="course_sequence",
            sequenceName = "course_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_sequence"
    )
    private Long courseId;
    private String courseTitle;
    private Integer credit;

    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher ;
//Many to many Mapping
    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name="student_course_mapping",
            joinColumns = @JoinColumn(
                    name="course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "studentId"
            )

    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students==null) students = new ArrayList<>();
        students.add(student);
    }

    public Course() {
    }

    public Course(String courseTitle, Integer credit, Teacher teacher) {
        this.courseTitle = courseTitle;
        this.credit = credit;
        this.teacher = teacher;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseId, course.courseId) &&
                Objects.equals(courseTitle, course.courseTitle) &&
                Objects.equals(credit, course.credit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseTitle, credit);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseTitle='" + courseTitle + '\'' +
                ", credit=" + credit +
                ", courseMaterial=" + courseMaterial +
                '}';
    }
}
