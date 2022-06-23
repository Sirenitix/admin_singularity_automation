package com.example.firstcase.filereader.services;

import org.springframework.web.multipart.MultipartFile;

public interface FraudService {
    void saveFileToData(MultipartFile files);
}
