package org.example.dao;


import org.example.model.StorePerson;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.util.List;

public interface DaoService {

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

    public void insertData(String id, String json);

    List<StorePerson> getCSV_row(String path);

    public List<String> getIdentifierList(String  path);

    public void truncateData();

    public List getIdListAndJsonList();
}
