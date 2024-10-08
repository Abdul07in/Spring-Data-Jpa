package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL Query : Based on Classes and not on sql tables
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentsByEmailAddress(String emailAddress);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailAddress);

    // Native Query
    @Query(value = "select * from tbl_student s where s.email_address = ?1", nativeQuery = true)
    Student getStudentsByEmailAddressNative(String emailAddress);

    // Native Named Param
    @Query(value = "select * from tbl_student s where s.email_address = :emailId", nativeQuery = true)
    Student getStudentsByEmailAddressNativeNamedParam(@Param("emailId") String emailAddress);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = ?1 where email_address = ?2", nativeQuery = true)
    int updateStudentNameByEmailAddress(String firstName, String emailId);


}
