package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.dao.DaoService;
import org.example.dao.StudentDao;
import org.example.dao.daoImpl.DaoImpl;
import org.example.model.Student;
import org.example.service.StudentService;
import org.example.service.TruncateAndInsertService;
import org.example.service.serviceImpl.StudentServiceImpl;
import org.example.service.serviceImpl.TruncateAndInsertImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws JsonProcessingException {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");

        TruncateAndInsertService truncateAndInsertService = new TruncateAndInsertImpl();
        truncateAndInsertService.truncateData();

        truncateAndInsertService.insertData("p1.csv");

        char ch = 'a';

        while (ch != 'x') {

            System.out.println("1.CREATE");
            System.out.println("2.RETRIEVE");
            System.out.println("3.UPDATE");
            System.out.println("4.DELETE");


            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter your choice");
            ch = sc.next().charAt(0);
            System.out.println();

            switch (ch) {

                case '1':
                    //create
                    System.out.print("Enter roll no := ");
                    int roll = sc.nextInt();
                    System.out.println("Enter name := ");
                    String name = sc.nextLine();
                    sc.nextLine();
                    System.out.println("Enter add := ");
                    String add = sc.nextLine();
                    System.out.println();

                    Student student1 = new Student();
                    student1.setRollNo(roll);
                    student1.setName(name);
                    student1.setAddress(add);

                    studentDao.insert(student1);
                    break;

                case '2':
                    //retrive
                    System.out.println("retrieving...");
                    List<Student> students = studentDao.findAllStudents();
                    System.out.println(students);
                    System.out.println();
                    break;

                case '3':
                    //update

                    System.out.print("Enter roll no := ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter add := ");
                    String a = sc.nextLine();

                    Student student2 = new Student();
                    student2.setRollNo(r);
                    student2.setAddress(a);
                    studentDao.updateStudent(student2);
                    System.out.println();
                    break;


                case '4':
                    //delete
                    System.out.println("Deleting");
                    System.out.print("Enter roll no := ");
                    int roll_no_ = sc.nextInt();
                    studentDao.delete(roll_no_);
                    System.out.println();
                    break;

                default:
                    break;

            }

        }

    }
}
