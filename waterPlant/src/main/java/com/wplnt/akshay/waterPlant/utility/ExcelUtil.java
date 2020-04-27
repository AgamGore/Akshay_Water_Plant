package com.wplnt.akshay.waterPlant.utility;

import com.wplnt.akshay.waterPlant.entity.Customer;
import com.wplnt.akshay.waterPlant.exception.ApplicationException;
import com.wplnt.akshay.waterPlant.exception.ErrorMessages;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Component
@Slf4j
public class ExcelUtil {

    public void write(List<Customer> custList, String excelFilePath) throws ApplicationException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Customer");
        // Creating Header
        createHeaderRow(sheet);
        // Creating Row
        int rowCount = 0;
        for (Customer aBook : custList) {
            Row row = sheet.createRow(++rowCount);
            writeBook(aBook, row);
        }
        try (FileOutputStream outputStream = new FileOutputStream(excelFilePath)) {
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            log.error("CustomerService :: postCustomerData() ::error ", e);
            throw new ApplicationException(e, ErrorMessages.FILE_NOT_FOUND);
        } catch (IOException e) {
            log.error("CustomerService :: postCustomerData() ::error ", e);
            throw new ApplicationException(e, ErrorMessages.EXCEL_FAILED);
        }
    }

    private void writeBook(Customer aBook, Row row) {
        Cell cell = row.createCell(0);
        cell.setCellValue(aBook.getName());

        cell = row.createCell(1);
        cell.setCellValue(aBook.getAddress());

        Cell cellMob = row.createCell(2);
        cellMob.setCellValue(aBook.getMobileNumber());

        Cell cellPrice = row.createCell(3);
        cellPrice.setCellValue(aBook.getBootleType());

        Cell cellPaymnt = row.createCell(4);
        cellPaymnt.setCellValue(aBook.getPaymentType());
    }

    private void createHeaderRow(Sheet sheet) {
        CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
        Font font = sheet.getWorkbook().createFont();
        font.setBoldweight((short) 10);
        font.setFontHeightInPoints((short) 16);
        cellStyle.setFont(font);

        Row row = sheet.createRow(0);
        Cell cellName = row.createCell(0);

        cellName.setCellStyle(cellStyle);
        cellName.setCellValue("Name");

        Cell cellAdd = row.createCell(1);
        cellAdd.setCellStyle(cellStyle);
        cellAdd.setCellValue("Address");

        Cell cellMob = row.createCell(2);
        cellMob.setCellStyle(cellStyle);
        cellMob.setCellValue("Mobile");

        Cell cellPrice = row.createCell(3);
        cellPrice.setCellStyle(cellStyle);
        cellPrice.setCellValue("Can Price");


        Cell cellPaymnt = row.createCell(4);
        cellPaymnt.setCellStyle(cellStyle);
        cellPaymnt.setCellValue("Payment Type");
    }
}
