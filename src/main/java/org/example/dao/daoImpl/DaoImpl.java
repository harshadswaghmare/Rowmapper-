package org.example.dao.daoImpl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import rowmapper.IdMapper;
import org.example.dao.DaoService;
import org.example.model.StorePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import rowmapper.JsonMapper;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Repository("dao")
public class DaoImpl implements DaoService {


    JdbcTemplate jdbcTemplate;

    @Autowired

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertData(String id, String json) {
        jdbcTemplate.update("INSERT INTO task2 (identifier, p_data) VALUES(?,?)", new Object[]{id, json}, new int[]{Types.VARCHAR, Types.OTHER});
    }


    @Override
    public List<StorePerson> getCSV_row(String path) {

        Pattern pattern = Pattern.compile(",");
        //create list
        List<StorePerson> list = new ArrayList<>();

        try {
            // create a reader
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);

            for (CSVRecord csvRecord : csvParser) {
                StorePerson p = new StorePerson();


                p.setAccountid(csvRecord.get(1));
                p.setAccountlogin(csvRecord.get(2));
                p.setEmail(csvRecord.get(3));
                p.setStatus(csvRecord.get(4));

                list.add(p);
            }

            // close the reader
            reader.close();
//some changes

        } catch (IOException ex) {
            ex.printStackTrace();
        }


        //return list
        return list;
    }

    @Override
    public List<String> getIdentifierList(String path) {

        Pattern pattern = Pattern.compile(",");

        //create list
        List<String> list = new ArrayList<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(path));
            CSVParser csvParser = CSVFormat.DEFAULT.parse(reader);
            csvParser.getRecords().forEach(csvRecords -> list.add(csvRecords.get(0)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //return list
        return list;
    }


    @Override
    public void truncateData() {
        StringBuffer TRUNCATE_USERS_SQL = new StringBuffer("truncate table task2");
        jdbcTemplate.update(TRUNCATE_USERS_SQL.toString());
    }

    @Override
    public List getIdListAndJsonList() {

        List<List<String>> main_list = new ArrayList<>();
        List<String> id_list = new ArrayList<>();
        List<String> json_list = new ArrayList<>();
        //SQL id
        StringBuffer SELECT_ID = new StringBuffer("select identifier from task2");
        id_list = jdbcTemplate.query(SELECT_ID.toString(), new IdMapper());
        //SQL DATA
        StringBuffer SELECT_JSON = new StringBuffer("select p_data from task2");
        json_list = jdbcTemplate.query(SELECT_JSON.toString(), new JsonMapper());

        main_list.add(id_list);
        main_list.add(json_list);

        return main_list;
    }
}