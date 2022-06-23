package com.example.firstcase.filereader.services;

import com.example.firstcase.filereader.entities.FraudEntity;
import com.example.firstcase.filereader.models.FraudReq;
import com.example.firstcase.filereader.repository.FraudRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FraudServiceImpl implements FraudService{
    @Autowired
    FraudRepository fraudRepository;
    @Override
    public void saveFileToData(MultipartFile files) {
        List<FraudReq> students = new ArrayList();
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(files.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Read student data form excel file sheet1.
        Sheet worksheet = workbook.getSheetAt(0);
        for (int index = 0; index < worksheet.getPhysicalNumberOfRows(); index++) {
            Row row = worksheet.getRow(index);
            FraudReq fraudReq = new FraudReq();
            fraudReq.setUser_id(getCellValue(row, 0));
            fraudReq.setLast_name(getCellValue(row, 1));
            fraudReq.setFirst_name(getCellValue(row, 2));
            fraudReq.setLesson_id(getCellValue(row, 3));
            fraudReq.setStep_id(getCellValue(row, 4));
            fraudReq.setStep_position(getCellValue(row, 5));
            fraudReq.setStep_url(getCellValue(row, 6));
            students.add(fraudReq);
        }


        // Save to db.
        List <FraudEntity>entities = new ArrayList();
        if (students.size() > 0) {
            students.forEach(x -> {
                FraudEntity fraud = new FraudEntity();
                fraud.setUser_id(x.getUser_id());
                fraud.setLastName(x.getLast_name());
                fraud.setFirstName(x.getFirst_name());
                fraud.setLesson_id(x.getLesson_id());
                fraud.setStep_id(x.getStep_id());
                fraud.setStepPosition(x.getStep_position());
                fraud.setStepURL(x.getStep_url());
                entities.add(fraud);
            });
            fraudRepository.saveAll(entities);
        }

    }

    private String getCellValue(Row row, int cellNo) {
        {
            DataFormatter formatter = new DataFormatter();
            Cell cell = row.getCell(cellNo);
            return formatter.formatCellValue(cell);
        }
    }
}
