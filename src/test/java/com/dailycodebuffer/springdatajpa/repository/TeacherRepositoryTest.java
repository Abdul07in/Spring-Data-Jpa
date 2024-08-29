package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Course;
import com.dailycodebuffer.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDSA = Course.builder()
                .courseTitle("DSA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .courseTitle("Java")
                .credit(5)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Amey")
                .lastName("Pandey")
//                .courses(List.of(courseDSA, courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}