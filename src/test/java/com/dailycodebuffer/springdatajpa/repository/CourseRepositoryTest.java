package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Course;
import com.dailycodebuffer.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void printAllCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Prajakta")
                .lastName("Kapoor")
                .build();


        Course course = Course.builder()
                .courseTitle("Python")
                .credit(5)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

}