package com.company;

import java.io.*;
import java.sql.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

/**
 * A simple Java program that exports data from database to Excel file.
 * @author Nam Ha Minh
 * (C) Copyright codejava.net
 */
public class Main {

    public static void main(String[] args) {
        new Main().export();
    }

    public void export() {
        String jdbcURL = "jdbc:mysql://localhost:3306/sampledb";
        String username = "root";
        String password = "";

        String excelFilePath = "nithin-export.xlsx";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "SELECT * FROM nithin";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("nithin");

            writeHeaderLine(sheet);

            writeDataLines(result, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Datababse error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("NAME");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Mobile number");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("EID");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Email");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Address");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

        while (result.next()) {
            String NAME = result.getString("NAME");
            String Mobile_number = result.getString("Mobile number");
            int EID = result.getInt("EID");
            String Email = result.getString("Email");
            String Address = result.getString("Address");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(NAME);

            cell = row.createCell(columnCount++);
            cell.setCellValue(Mobile_number);

            cell = row.createCell(columnCount++);

            CellStyle cellStyle = workbook.createCellStyle();
            CreationHelper creationHelper = workbook.getCreationHelper();
            cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
            cell.setCellStyle(cellStyle);

            cell.setCellValue(EID);

            cell = row.createCell(columnCount++);
            cell.setCellValue(Email);

            cell = row.createCell(columnCount);
            cell.setCellValue(Address);

        }
    }
}

