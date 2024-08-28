package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);
    public List<Student> findByLastNameNotNull();
    public List<Student> findByGuardianName(String guardianName);
    public Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL Query : Based on Classes and not on sql tables
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentsByEmailAddress(String emailAddress);
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    // Native Query

    @Query(value = "select * from tbl_student s where s.email_address = ?1" , nativeQuery = true)
    Student getStudentsByEmailAddressNative(String emailAddress);


}
