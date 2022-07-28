package org.example;

import org.example.dao.StudentDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println("application context loaded");

        StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);
//        studentDao.insert(newStudent1);
//        studentDao.cleanUp();

//        List<Student> studentList = studentDao.findAllStudents();
//        studentDao.printStudent(studentList);

//        Student newStudent2 = new Student();
//        newStudent2.setRollNo(1);
//        newStudent2.setName("bob1");
//        newStudent2.setAddress("ameria1");


//        Student newStudent3 = new Student();
//        newStudent3.setRollNo(2);
//        newStudent3.setName("bob2");
//        newStudent3.setAddress("ameria2");

//        Student newStudent4 = new Student();
//        newStudent4.setRollNo(3);
//        newStudent4.setName("bob3");
//        newStudent4.setAddress("ameria3");

//        Student newStudent5 = new Student();
//        newStudent5.setRollNo(4);
//        newStudent5.setName("bob4");
//        newStudent5.setAddress("ameria4");

//        List<Student> list = new ArrayList<>();
//        list.add(newStudent2);
//        list.add(newStudent3);
//        list.add(newStudent4);
//        list.add(newStudent5);

        Student update_student = new Student();
        update_student.setRollNo(1);
        update_student.setName("updatedName");
        update_student.setAddress("updatedAddress");

        studentDao.updateStudent(update_student);


//         studentDao.insertBatch(list);


    }
}
