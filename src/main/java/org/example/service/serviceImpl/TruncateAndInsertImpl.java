package org.example.service.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.example.dao.DaoService;
import org.example.dao.daoImpl.DaoImpl;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.model.StorePerson;
import org.example.service.TruncateAndInsertService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


/************************************FUNCTION FOR TRUNCATE AND INSERT***********************/
public class TruncateAndInsertImpl implements TruncateAndInsertService {



     public void truncateData() {
        DaoService daoService = new DaoImpl();
        daoService.truncateData();
    }


    @Override
    public void insertData(String path) throws JsonProcessingException {

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

        DaoImpl daoService = context.getBean("dao", DaoImpl.class);

        //step 1 : filter the identifier
        List<String> identifier_list = daoService.getIdentifierList(path);
        //step 2 : filter the json
        List<StorePerson> json_list = daoService.getCSV_row(path);


        //store the data iteratively
        for (int i = 0; i < identifier_list.size(); i++) {
            //get id
            String id_to_store = identifier_list.get(i);
            //get java object
            StorePerson person = new StorePerson(json_list.get(i).getAccountlogin(), json_list.get(i).getAccountid(), json_list.get(i).getStatus(), json_list.get(i).getEmail());
            //creating object mapper
            ObjectMapper Obj = new ObjectMapper();
            String jsonStr = Obj.writeValueAsString(person);
            //Step 3: store the data
            daoService.insertData(id_to_store, jsonStr);
        }//for

    }
}

