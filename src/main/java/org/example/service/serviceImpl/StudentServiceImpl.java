package org.example.service.serviceImpl;

import org.example.model.Student;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;
@Repository("service")
public class StudentServiceImpl implements StudentService {

    ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
    StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);

    @Override
    public void insert(Student student) {
        studentDao.insert(student);
    }

    @Override
    public void insertBatch(List<Student> student) {
        studentDao.insertBatch(student);
    }

    @Override
    public int updateStudent(Student student) {
        studentDao.updateStudent(student);
        return 0;
    }

    @Override
    public List<Student> findAllStudents() {
        List<Student> list = studentDao.findAllStudents();
        return list;
    }

    @Override
    public DataSource getDataSource() {
        return null;
    }

    @Override
    public void printStudent(List<Student> students) {
        studentDao.printStudent(students);
    }

    @Override
    public void cleanUp() {
        studentDao.cleanUp();
    }

    @Override
    public Student findStudentByRollNo(int rn) {
        Student student = studentDao.findStudentByRollNo(rn);
        return student;
    }

    @Override
    public int getAllStudCount() {
       int count =studentDao.getStudCount();
       return count;
    }

    @Override
    public void deleteStud(int roll) {
        studentDao.delete(roll);
    }


}
