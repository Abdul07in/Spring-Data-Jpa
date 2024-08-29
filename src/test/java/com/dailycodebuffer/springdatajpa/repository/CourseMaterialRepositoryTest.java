package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Course;
import com.dailycodebuffer.springdatajpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .courseTitle(".Net")
                .credit(5)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .courseUrl("www.dsaNet.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCourses() {
        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}