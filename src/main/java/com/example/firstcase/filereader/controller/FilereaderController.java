package com.example.firstcase.filereader.controller;

import com.example.firstcase.filereader.services.FraudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/fraud")
public class FilereaderController {
    @Autowired
    FraudService fraudService;

    @PostMapping(value = "/import-order-excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String importExcelFile( @RequestParam("file")MultipartFile files) {
        fraudService.saveFileToData(files);
        return "DONE";
    }

}
