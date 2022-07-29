package org.example;

import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.model.Emp;
import org.example.model.Pepsi;
import org.example.model.Samosa;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        System.out.println("application context loaded");

        //StudentDaoImpl studentDao = context.getBean("studentDao", StudentDaoImpl.class);
         Emp  emp = context.getBean(Emp.class);
         System.out.println(emp.getAddress());

        /*********************insert object***************/
        Student student = new Student();
        student.setRollNo(11);
        student.setName("11 record");
        student.setAddress("11 address");

        //studentDao.insert(student);

        /*****************Trunccate table******************/
        //studentDao.cleanUp();

        /*****************Print student*******************/
        //List<Student> studentList = studentDao.findAllStudents();
        //studentDao.printStudent(studentList);

        /***********Batch insert*******************/
        //        Student newStudent2 = new Student();
        //        newStudent2.setRollNo(1);
        //        newStudent2.setName("bob1");
        //        newStudent2.setAddress("ameria1");
        //
        //
        //        Student newStudent3 = new Student();
        //        newStudent3.setRollNo(2);
        //        newStudent3.setName("bob2");
        //        newStudent3.setAddress("ameria2");
        //
        //        Student newStudent4 = new Student();
        //        newStudent4.setRollNo(3);
        //        newStudent4.setName("bob3");
        //        newStudent4.setAddress("ameria3");
        //
        //        Student newStudent5 = new Student();
        //        newStudent5.setRollNo(4);
        //        newStudent5.setName("bob4");
        //        newStudent5.setAddress("ameria4");
        //
        //        List<Student> list = new ArrayList<a>();
        //        list.add(newStudent2);
        //        list.add(newStudent3);
        //        list.add(newStudent4);
        //        list.add(newStudent5);
        //
        //        Student update_student = new Student();
        //        update_student.setRollNo(1);
        //        update_student.setAddress("updatedAddress");


        /***************insert batch**************/
        //studentDao.insertBatch(list);

        /***************update student ******************/
        //studentDao.updateStudent(update_student);

        /***************find student by roll is *********************/
        //studentDao.findStudentByRollNo(1);

        //xml-byname,bytype,constructor,
        //annotation autowired

        //automatic
        //less code

        //no control of programmer
        //it can't be used for primitive and string values




    }
}
