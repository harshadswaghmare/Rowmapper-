package org.example.dao;

import org.example.model.Student;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public interface StudentDao {

    public void insert(Student student);

    public int delete(int roll);

    public void insertBatch(List<Student> student);

    public int updateStudent(Student student);

    public List<Student> findAllStudents();

    public DataSource getDataSource();

    public void printStudent(List<Student> students);

    public void cleanUp();

    public Student findStudentByRollNo(int rn);

    public  int getStudCount();

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}
