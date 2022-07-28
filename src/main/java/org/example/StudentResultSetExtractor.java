package org.example;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentResultSetExtractor implements ResultSetExtractor<List<Student>> {
    @Override
    public List<Student> extractData(ResultSet res) throws SQLException, DataAccessException {

        List<Student> studentList = new ArrayList<Student>();

        while(res.next()){

            Student newStudent = new Student();

            res.getString("rollNo");
            res.getString("name");
            res.getString("address");
        }

        return null;
    }
}
