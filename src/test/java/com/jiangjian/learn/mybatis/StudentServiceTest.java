package com.jiangjian.learn.mybatis;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jiangjian.learn.mybatis.entity.Student;
import com.jiangjian.learn.mybatis.service.StudentService;

import junit.framework.Assert;

public class StudentServiceTest {
	private static StudentService studentService;
	
	@BeforeClass
	public static void setup() {
		studentService = new StudentService();
	}
	
	@AfterClass
	public static void reardown() {
		studentService = null;
	}
	
	@Test
	public void testFindAllStudents() {
		List<Student> students = studentService.findAllStudents();
		Assert.assertNotNull(students);
		for(Student stu : students) {
			System.out.println(stu);
		}
	}
	
	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
		System.out.println(student);
	}
	
	@Test
	public void testCreateStudent() {
		Student student = new Student();
		student.setStudId(5);
		student.setEmail("student5@gmail.com");
		student.setName("studentQp5");
		student.setDob(new Date());
		studentService.insertStudent(student);
		Student newStudent = studentService.findStudentById(5);
		Assert.assertEquals("student5", newStudent.getName());
	}
}
