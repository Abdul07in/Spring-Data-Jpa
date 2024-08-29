package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Course;
import com.dailycodebuffer.springdatajpa.entity.Student;
import com.dailycodebuffer.springdatajpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
        Teacher teacher = Teacher.builder().firstName("Prajakta").lastName("Kapoor").build();


        Course course = Course.builder().courseTitle("Python").credit(5).teacher(teacher).build();

        courseRepository.save(course);
    }


    @Test
    public void findAllPagination() {
        Pageable firstPageWithThree = PageRequest.of(0, 3);
        Pageable secondPageWithTwo = PageRequest.of(1, 2);

        List<Course> courseList = courseRepository.findAll(firstPageWithThree).getContent();

        Long totalElement = courseRepository.findAll(firstPageWithThree).getTotalElements();

        long totalPages = courseRepository.findAll(firstPageWithThree).getTotalPages();

        System.out.println("totalElement = " + totalElement);
        System.out.println("totalPages = " + totalPages);
        System.out.println("courseList = " + courseList);
    }

    @Test
    public void findAllWithSorting() {

        Pageable sortByTitle = PageRequest.of(0, 2, Sort.by("courseTitle"));
        Pageable sortByCredit = PageRequest.of(0, 2, Sort.by("credit"));

        List<Course> courseListSortByTitle = courseRepository.findAll(sortByTitle).getContent();
        List<Course> courseListSortByCredit = courseRepository.findAll(sortByCredit).getContent();

        System.out.println("courseListSortByTitle = " + courseListSortByTitle);
        System.out.println("courseListSortByCredit = " + courseListSortByCredit);

    }

    @Test
    public void findByPageContaining() {
        Pageable firstTenRequest = PageRequest.of(0, 10);
        List<Course> courseList = courseRepository.findAllByCourseTitleContaining("D", firstTenRequest).getContent();

        System.out.println("courseList = " + courseList);

    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Sanjay")
                .lastName("Dutt")
                .build();

        Student student = Student.builder()
                .firstName("Aniket")
                .lastName("Gupta")
                .emailId("aniket@gmail.com")
                .build();

        Course course = Course.builder()
                .courseTitle("React")
                .credit(12)
                .teacher(teacher)
                .build();

        course.addStudents(student);

        courseRepository.save(course);

    }

}