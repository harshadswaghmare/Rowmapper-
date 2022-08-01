package org.example.dao.daoImpl;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.example.dao.DaoService;
import org.example.model.StorePerson;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;


@Repository("dao")
public class DaoImpl implements DaoService {


    JdbcTemplate jdbcTemplate;

    @Override
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insertData(String id, String json) {

        StringBuffer INSERT_USERS_SQL = new StringBuffer("INSERT INTO task2 (identifier, p_data) VALUES(?,? format json);");

        //Step 1: create connection

        //        A program has to do more than rely on the garbage collector (GC) to reclaim a resource's memory when it's
        //        finished with it. The program must also release the resoure back to the operating system, typically by calling
        //        the resource's close method. However, if a program fails to do this before the GC reclaims the resource, then
        //        the information needed to release the resource is lost.
        //        The resource, which is still considered by the operaing system to be in use, has leaked.
        //        In this example, if the readLine method throws an exception,
        //        and the statement br.close() in the finally block throws an exception,
        //        then the FileReader has leaked. Therefore, use a try-with-resources statement
        //        instead of a finally block to close your program's resources.

        Object args[] = {id, json};
        jdbcTemplate.update(INSERT_USERS_SQL.toString(), args);
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

        return main_list;
    }


}