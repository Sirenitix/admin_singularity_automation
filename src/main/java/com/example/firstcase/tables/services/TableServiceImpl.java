package com.example.firstcase.tables.services;

import com.example.firstcase.tables.entities.TableEntity;
import com.example.firstcase.tables.repository.TableRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    static final String DB_URL = "jdbc:postgresql://ec2-52-49-120-150.eu-west-1.compute.amazonaws.com:5432/d7nh4fa0f4uak4";
    static final String USER = "uvfulupzfdmryy";
    static final String PASS = "7d86d1bd787fdb2afca058ffd8d791d71144d6cfad37a9870d18e2f68bcb2abd";
    @Autowired
    TableRepository tableRepository;


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
            preparedStatement.close();


            System.out.println("Created table in given database...");
            createTable(columnNames, conn);
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
                stringBuilder.append("_" + repeat);
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


    private void createTable(List list, Connection conn) {

        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT user_id, invitation_email,total FROM tabel_uspevaemosti_data";
            ResultSet rs = stmt.executeQuery(sql);
            TableEntity tableEntity = new TableEntity();
            while (rs.next()) {
                String id = rs.getString("user_id");
                String email = rs.getString("invitation_email");
                tableEntity.setStepikID(id);
                tableEntity.setEmail(email);
                tableEntity.setProgress("total");
                tableRepository.save(tableEntity);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //STEP 5: Extract data from result set

    }
}