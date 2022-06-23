package com.example.firstcase.tables.services;

import org.springframework.web.multipart.MultipartFile;

public interface TableService {
    void createTable(MultipartFile files);
}
