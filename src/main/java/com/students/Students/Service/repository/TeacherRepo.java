package com.students.Students.Service.repository;

import com.students.Students.Service.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Long> {

}
