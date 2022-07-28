package org.example.dao;

import org.example.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public interface StudentDao {

    public void insert(Student student);

    public void insertBatch(List<Student> student);

    public int updateStudent(Student student);

    public List<Student> findAllStudents();

    public DataSource getDataSource();

    public void printStudent(List<Student> students);

    public void cleanUp();

    public Student findStudentByRollNo(int rn);

}
