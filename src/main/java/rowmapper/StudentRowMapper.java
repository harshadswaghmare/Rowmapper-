package rowmapper;

import org.example.model.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet res, int rowNum) throws SQLException {

        Student newStudent = new Student();

        newStudent.setRollNo(res.getInt("rollNo"));
        newStudent.setName(res.getString("name"));
        newStudent.setAddress(res.getString("address"));

        return newStudent;
    }
}
