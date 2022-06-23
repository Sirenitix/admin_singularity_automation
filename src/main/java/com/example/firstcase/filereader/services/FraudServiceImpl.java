package com.example.firstcase.filereader.services;

import com.example.firstcase.tables.services.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FraudServiceImpl implements FraudService {
    @Autowired
    TableService tableService;

    @Override
    public void saveFileToData(MultipartFile files) {

        tableService.createTable(files);
    }
}
