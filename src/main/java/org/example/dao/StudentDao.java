package org.example.dao;

import org.example.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student student);

    public void insertBatch(List<Student> student);

    public int updateStudent(Student student);

}
