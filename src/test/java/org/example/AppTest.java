package org.example;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.example.dao.daoImpl.StudentDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest {

        @Test
        public void Test1(){
            ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
            System.out.println("application context loaded");
            StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);
            assertEquals(4, studentDao.findAllStudents().size());
        }
}
