package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Guardian;
import com.dailycodebuffer.springdatajpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentUsingSaveMethodOfRepository() {
        Student student = Student.builder()
                .emailId("abdulkanoo@gmail.com")
                .firstName("Abdul Majeed")
                .lastName("Kanoor")
//                .guardianName("Dilshad")
//                .guardianEmail("dkanoor786@gmail.com")
//                .guardianMobile("9022226754")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentsWithGuardian() {

        Guardian guardian = Guardian.builder()
                .name("Dilshad")
                .email("dkanoor786@gmail.com")
                .mobile("9022226754")
                .build();

        Student student = Student.builder()
                .firstName("Aziz")
                .lastName("Kanoor")
                .emailId("azizkanoor@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }

    @Test
    public void getAllStudentWithFindAllMethod() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void findStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Aziz");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Abdul");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentsByGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Dilshad");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentsByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("Abdul Aziz", "Kanoor");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddress() {
        Student student = studentRepository.getStudentsByEmailAddress("abdulkanoo@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstByEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("abdulkanoo@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNative() {
        Student student = studentRepository.getStudentsByEmailAddressNative("abdulkanoo@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentsByEmailAddressNativeNamedParam("abdulkanoo@gmail.com");
        System.out.println("student = " + student);
    }


    @Test
    public void updateStudentNameByEmailAddress() {
        int i = studentRepository.updateStudentNameByEmailAddress("Abdul Majeed", "abdulkanoo@gmail.com");
    }

}