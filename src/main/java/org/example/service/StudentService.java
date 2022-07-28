package org.example.service;

import org.example.Student;

import javax.sql.DataSource;
import java.util.List;

public interface StudentService {

    public void insert(Student student);

    public void insertBatch(List<Student> student);

    public int updateStudent(Student student);

    public List<Student> findAllStudents();

    public DataSource getDataSource();

    public void printStudent(List<Student> students);

    public void cleanUp();

    public Student findStudentByRollNo(int rn);
}
