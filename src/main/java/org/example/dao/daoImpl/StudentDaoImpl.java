package org.example.dao.daoImpl;

import org.example.Student;
import org.example.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import rowmapper.StudentRowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Repository("studentDao")
//perform different operation
public class StudentDaoImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Student student) {
        String sql = "insert into student values(?,?,?)";
        Object[] arg = {student.getRollNo(), student.getName(), student.getAddress()};
        jdbcTemplate.update(sql, arg);
    }

    @Override
    public void insertBatch(List<Student> student) {
        String sql = "insert into student values (?,?,?)";
        ArrayList<Object[]> sqlArgs = new ArrayList<>();
        for (Student tempStudent : student) {
            Object[] studentData = {tempStudent.getRollNo(), tempStudent.getName(), tempStudent.getAddress()};
            sqlArgs.add(studentData);
        }
        jdbcTemplate.batchUpdate(sql, sqlArgs);
    }

    @Override
    public int updateStudent(Student student) {
        String SQL = "update student set address = ? where \"rollNo\" = ?";
        Object args[] = {student.getAddress(), student.getRollNo()};
        return jdbcTemplate.update(SQL, args);
    }

    public List<Student> findAllStudents() {
        String selectQ = "select * from student";
        List<Student> studentList = jdbcTemplate.query(selectQ, new BeanPropertyRowMapper<Student>(Student.class));
        return studentList;
    }

    public DataSource getDataSource() {
        DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/task2_db", "postgres", "admin");
        return dataSource;
    }

    public void printStudent(List<Student> students) {

        for (Student tempStudent : students) {
            System.out.println(tempStudent.toString());
        }
    }

    public void cleanUp() {
        String sql = "TRUNCATE TABLE STUDENT";
        jdbcTemplate.update(sql);
        System.out.println("table cleaned up...");
    }

    public Student findStudentByRollNo(int rn) {
        String selectSql = "select * from student where \"rollNo\"=?";
        Student student = jdbcTemplate.queryForObject(selectSql, new BeanPropertyRowMapper<Student>(Student.class), rn);
        return student;
    }

    // public Student findStudentByName(String name) {
    // String selectSql = "select * from student where name=?";
    // jdbcTemplate.query(selectSql,res,name);
    // return student;
    //}

}
