package com.example.firstcase.tables.services;

import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USER = "postgres";
    static final String PASS = "123456";


    @Override
    public void createTable(MultipartFile files) {
        String tableName = files.getOriginalFilename().replace(".xlsx", "_data");
        System.out.println(tableName);
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(files.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Sheet worksheet = workbook.getSheetAt(0);
        Row row = worksheet.getRow(0);
        List<String> columnNames = getColumnNames(row);
        for (String s : columnNames) System.out.println(s);


        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {

            String sql = String.format("CREATE TABLE IF NOT EXISTS " + tableName + " (" + columnNames.get(0) + " VARCHAR(255))");
            stmt.executeUpdate(sql);
            for (int i = 1; i < columnNames.size(); i++) {

                sql = String.format("ALTER TABLE IF EXISTS " + tableName + " ADD COLUMN IF NOT EXISTS " + columnNames.get(i) + " VARCHAR(255);");
                System.out.println("ALTER TABLE IF EXISTS " + tableName + " ADD COLUMN " + columnNames.get(i) + " VARCHAR(255);");
                stmt.executeUpdate(sql);
            }

            String column = "";
            for (int i = 0; i < columnNames.size() - 1; i++) {
                column = column + columnNames.get(i) + ", ";
            }
            column = column + columnNames.get(columnNames.size() - 1);
            String q = "";
            for (int i = 0; i < columnNames.size() - 1; i++) {
                q = q + "?, ";
            }
            q = q + "?";
            String s = "INSERT INTO " + tableName + " (" + column + ") VALUES (" + q + ")";

            PreparedStatement preparedStatement = conn.prepareStatement(s);

            for (int index = 1; index < worksheet.getPhysicalNumberOfRows(); index++) {
                Row rowOfTable = worksheet.getRow(index);
                for (int i = 1; i <= columnNames.size(); i++) {
                    String line = getCellValue(rowOfTable, i - 1);
                    preparedStatement.setString(i, line);
                }
                preparedStatement.executeUpdate();
            }


            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<String> getColumnNames(Row row) {
        int count = 0;
        List<String> columnNames = new ArrayList<>();
        StringBuilder stringBuilder;
        int repeat = 1;
        while (true) {
            String name = getCellValue(row, count);

            if (name.isEmpty()) break;
            stringBuilder = new StringBuilder();

            for (int i = 0; i < name.length(); i++) {
                if (Character.isAlphabetic(name.charAt(i))
                        || name.charAt(i) == '_'
                        || Character.isDigit(name.charAt(i)))
                    stringBuilder.append(name.charAt(i));
            }
            if (columnNames.contains(stringBuilder.toString())) {
                stringBuilder.append("_"+repeat);
                repeat++;
            }

            columnNames.add(stringBuilder.toString());
            count++;
        }
        return columnNames;
    }

    private String getCellValue(Row row, int cellNo) {
        {
            DataFormatter formatter = new DataFormatter();
            Cell cell = row.getCell(cellNo);
            return formatter.formatCellValue(cell);
        }
    }
}