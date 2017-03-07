package com.jiangjian.learn.mybatis.entity.mappers;

import java.util.List;

import com.jiangjian.learn.mybatis.entity.Student;

public interface StudentMapper {
	List<Student> findAllStudents();
	Student findStudentById(Integer id);
	void insertStudent(Student student);
}
