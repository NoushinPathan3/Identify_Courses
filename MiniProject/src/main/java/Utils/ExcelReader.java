package Utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {

    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";

    public static String getCellData(int row, int col) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row r = sheet.getRow(row);
            if (r == null) return "";

            Cell c = r.getCell(col);
            if (c == null) return "";

            c.setCellType(CellType.STRING);
            return c.getStringCellValue().trim();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int getRowCount() {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            return workbook.getSheetAt(0).getLastRowNum();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }


    public static void writeActualResult(int rowIndex, String actualResult) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
            if (row == null) row = sheet.createRow(rowIndex);

            Cell cell = row.getCell(3); // Actual column
            if (cell == null) cell = row.createCell(3);

            cell.setCellValue(actualResult);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void writeStatus(int rowIndex, String status) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);
            Row row = sheet.getRow(rowIndex);
            if (row == null) row = sheet.createRow(rowIndex);

            Cell cell = row.getCell(4); // Status column
            if (cell == null) cell = row.createCell(4);

            cell.setCellValue(status);

            CellStyle style = workbook.createCellStyle();
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            if (status.equalsIgnoreCase("PASS")) {
                style.setFillForegroundColor(
                        new XSSFColor(new java.awt.Color(144, 238, 144), null)
                );
            } else {
                style.setFillForegroundColor(
                        new XSSFColor(new java.awt.Color(255, 182, 193), null)
                );
            }

            cell.setCellStyle(style);

            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}