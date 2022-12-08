package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.cli.*;
import org.example.dao.DaoService;
import org.example.dao.StudentDao;
import org.example.dao.daoImpl.DaoImpl;
import org.example.model.Student;
import org.example.service.JsonToCSVService;
import org.example.service.StudentService;
import org.example.service.TruncateAndInsertService;
import org.example.service.serviceImpl.JsonToCSVImpl;
import org.example.service.serviceImpl.StudentServiceImpl;
import org.example.service.serviceImpl.TruncateAndInsertImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class App {

    private static void printHelp(Options options) {
        HelpFormatter formatter = new HelpFormatter();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("MathApp");
        pw.println();
        formatter.printUsage(pw, 100,
                "java -jar MathApp.jar [options] input1 input2");
        formatter.printOptions(pw, 100, options, 2, 5);
        pw.close();
        System.out.println();
    }

    public static void main(String[] args) throws IOException, ParseException {

        Options options = new Options();


        options.addOption("cs", false, "create students[arg-1][arg-2][arg-3][stud_roll][stud_name][stud_add]");
        options.addOption("fs", false, "find students");
        options.addOption("us", false, "update students[arg-1][arg-2][stud_roll][stud_add]");
        options.addOption("ds", false, "delete numbers[arg-1][stud_rol]");
        options.addOption("ti", false, "truncate and insert data[arg-1][path_of_csv_file]");
        options.addOption("jc", false, "json to csv[arg-1][path_of_csv_file]");
        options.addOption("help", false, "help");


        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");
        TruncateAndInsertService truncateAndInsertService = context.getBean("tai", TruncateAndInsertImpl.class);
        JsonToCSVService jsonToCSVService = context.getBean("jtc", JsonToCSVImpl.class);
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);

        //***Interrogation Stage***
        //hasOptions checks if option is present or not
        if (cmd.hasOption("cs")) {
            Student student1 = new Student();
            //give three args
            student1.setRollNo(Integer.parseInt(args[1]));
            student1.setName(args[2]);
            student1.setAddress(args[3]);
            studentDao.insert(student1);
            System.out.println("Student inserted");

        } else if (cmd.hasOption("fs")) {
            //retrive all studs
            System.out.println("retrieving...");
            List<Student> students = studentDao.findAllStudents();
            System.out.println(students);
            System.out.println();
        } else if (cmd.hasOption("us")) {
            //give 2 args
            Student student2 = new Student();
            student2.setRollNo(Integer.parseInt(args[1]));
            student2.setAddress(args[2]);
            studentDao.updateStudent(student2);
            System.out.println();
        } else if (cmd.hasOption("ds")) {
            //give 1 arg
            System.out.println("Deleting");
            studentDao.delete(Integer.parseInt(args[1]));
            System.out.println();
        } else if (cmd.hasOption("ti")) {
            //give 1 arg
            System.out.println("processing");
            truncateAndInsertService.truncateData();
            truncateAndInsertService.insertData(args[1]);
        } else if (cmd.hasOption("jc")) {
            //give 1 arg
            jsonToCSVService.json_to_CSV();
        } else if (cmd.hasOption("help")) {
            printHelp(options);
        }

    }

}
