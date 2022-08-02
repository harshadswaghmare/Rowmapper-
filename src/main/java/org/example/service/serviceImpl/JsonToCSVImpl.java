package org.example.service.serviceImpl;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.example.dao.DaoService;
import org.example.dao.daoImpl.DaoImpl;
import org.example.model.RetrievePerson;
import org.example.model.StorePerson;
import org.example.service.JsonToCSVService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JsonToCSVImpl implements JsonToCSVService {

    /***********************************function for JSON TO CSV ***************************/
    public List<RetrievePerson> json_to_CSV(String path) throws IOException {

        List<String> id_list;
        List<String> json_list;
        List<RetrievePerson> person_list = new ArrayList<>();

        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        DaoImpl daoService = (DaoImpl) context.getBean("dao");

        List<List<String>> id_and_json_list = new ArrayList<>();
        id_and_json_list = daoService.getIdListAndJsonList();

        id_list = id_and_json_list.get(0);
        json_list = id_and_json_list.get(1);


        //CONVERTING TO POJO
        for (int i = 0; i < json_list.size(); i++) {

            String string = json_list.get(i);

            ObjectMapper mapper = new ObjectMapper();
            StorePerson store_person = mapper.readValue(string, StorePerson.class);

            RetrievePerson retrievePerson = new RetrievePerson();

            retrievePerson.setIdentifier(id_list.get(i));
            retrievePerson.setAccountlogin(store_person.getAccountlogin());
            retrievePerson.setAccountid(store_person.getAccountid());
            retrievePerson.setEmail(store_person.getEmail());
            retrievePerson.setStatus(store_person.getStatus());

            person_list.add(retrievePerson);
        }


        File csvOutputFile = new File("src/main/resources/p2.csv");
        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
        CsvSchema schema = CsvSchema.builder().setUseHeader(true).addColumn("identifier").addColumn("accountlogin").addColumn("accountid").addColumn("status").addColumn("email").build().withoutHeader();
        ObjectWriter writer = mapper.writerFor(RetrievePerson.class).with(schema);
        writer.writeValues(csvOutputFile).writeAll(person_list);
        System.out.println("Users saved to csv file under path: ");
        System.out.println(csvOutputFile);


        return person_list;
    }

}
