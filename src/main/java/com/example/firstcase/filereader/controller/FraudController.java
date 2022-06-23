package com.example.firstcase.filereader.controller;

import com.example.firstcase.filereader.services.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fraud")
public class FraudController {
    @Autowired
    FraudService fraudService;

    @PostMapping(value = "/import-order-excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String importExcelFile( @RequestParam("file")MultipartFile files) throws IOException {
        fraudService.saveFileToData(files);
        return "DONE";
    }

}
