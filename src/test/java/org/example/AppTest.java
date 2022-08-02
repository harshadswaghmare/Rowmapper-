package org.example;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.example.dao.StudentDao;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.serviceImpl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

        @Test
        public void getUsersTest(){
            ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
            StudentService studentService = new StudentServiceImpl();
            assertEquals(11, studentService.findAllStudents().size());
        }

        @BeforeEach
        public void getUserByRollNo()     {
            StudentService studentService = new StudentServiceImpl();
            when(studentService.findStudentByRollNo(1)).thenReturn(new Student(1,"person1","kjhj"));

        }

}
