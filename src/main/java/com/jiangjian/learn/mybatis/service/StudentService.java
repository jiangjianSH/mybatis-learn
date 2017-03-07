package com.jiangjian.learn.mybatis.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jiangjian.learn.mybatis.entity.Student;
import com.jiangjian.learn.mybatis.entity.mappers.MyBatisSqlSessionFactory;
import com.jiangjian.learn.mybatis.entity.mappers.StudentMapper;

public class StudentService {
	private Logger logger = LoggerFactory.getLogger(StudentService.class);

	public List<Student> findAllStudents() {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudents();
		} finally {
			sqlSession.close();
		}
	}

	public Student findStudentById(Integer studId) {
		logger.debug("Select Student By ID:}", studId);
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentById(studId);
		}finally {
			sqlSession.close();
		}
	}

	public void insertStudent(Student student) {
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			studentMapper.insertStudent(student);
			sqlSession.commit();
		}finally {
			sqlSession.close();
		}
	}
}
