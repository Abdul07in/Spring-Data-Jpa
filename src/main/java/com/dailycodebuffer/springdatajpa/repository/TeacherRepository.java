package com.dailycodebuffer.springdatajpa.repository;

import com.dailycodebuffer.springdatajpa.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
