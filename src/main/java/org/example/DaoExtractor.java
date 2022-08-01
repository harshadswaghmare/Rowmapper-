package org.example;

import org.example.model.Student;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoExtractor implements ResultSetExtractor<List<String>> {
    @Override
    public List<String> extractData(ResultSet res) throws SQLException, DataAccessException {

        List<String> stringList = new ArrayList<>();

        while(res.next()){
            stringList.add(res.getString(0));
            stringList.add(res.getString(1));
        }

        return null;
    }
}
