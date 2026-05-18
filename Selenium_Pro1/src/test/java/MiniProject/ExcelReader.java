//package MiniProject;
//
//import org.apache.poi.ss.usermodel.*;
//import java.io.FileInputStream;
//
//public class ExcelReader {
//
//    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";
//
//    public static String getCellData(int row, int col) {
//        try {
//            FileInputStream fis = new FileInputStream(FILE_PATH);
//            Workbook workbook = WorkbookFactory.create(fis);
//            Sheet sheet = workbook.getSheetAt(0);
//
//            Row r = sheet.getRow(row);
//            Cell c = r.getCell(col);
//
//            workbook.close();
//            return c.toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}



package MiniProject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {

    private static final String FILE_PATH = "src/test/resources/TestData.xlsx";

    // ✅ Read cell data
    public static String getCellData(int row, int col) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            return workbook.getSheetAt(0)
                    .getRow(row)
                    .getCell(col)
                    .toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    // ✅ FORCE color using RGB (theme-safe)
    public static void writeStatus(String status) {

        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheetAt(0);

            XSSFRow row = sheet.getRow(1);
            if (row == null) row = sheet.createRow(1);

            XSSFCell cell = row.getCell(4);
            if (cell == null) cell = row.createCell(4);

            cell.setCellValue(status);

            // ✅ Clear any existing style
            cell.setCellStyle(workbook.createCellStyle());

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            if (status.equalsIgnoreCase("Pass")) {
                style.setFillForegroundColor(
                        new XSSFColor(new byte[]{(byte) 144, (byte) 238, (byte) 144}, null)
                ); // Light green RGB
            } else {
                style.setFillForegroundColor(
                        new XSSFColor(new byte[]{(byte) 255, (byte) 182, (byte) 193}, null)
                ); // Light rose RGB
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