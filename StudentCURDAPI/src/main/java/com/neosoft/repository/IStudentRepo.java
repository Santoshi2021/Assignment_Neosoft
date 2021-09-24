package com.neosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neosoft.model.Student;

/**
 * The Interface IStudentRepository.
 * 
 * @author Santoshi Yadav
 * 
 */
public interface IStudentRepo extends JpaRepository<Student, Integer> {

}
