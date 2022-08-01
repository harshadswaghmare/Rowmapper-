package org.example.service;

import com.fasterxml.jackson.core.JsonProcessingException;


import java.util.List;

public interface TruncateAndInsertService {

    public void truncateData();

    public void insertData(String path) throws JsonProcessingException;
}
