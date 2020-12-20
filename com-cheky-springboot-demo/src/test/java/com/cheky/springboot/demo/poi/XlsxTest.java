package com.cheky.springboot.demo.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XlsxTest {

    private final String filePath = XlsxTest.class.getResource("").getPath();
    //往excel写入数据
    @Test
    public void write() throws Exception {
        // 创建工作簿
        Workbook workbook = new HSSFWorkbook();
        // 创建工作表
        Sheet sheet = workbook.createSheet();
        // 创建第一行
        Row row = sheet.createRow(0);
        // 创建第一行的第一列
        Cell cell = row.createCell(0);
        // 往单元格设置内容
        cell.setCellValue("第一行第一列Demo1");

        // 输出excel
        workbook.write(new FileOutputStream(filePath + "\\demo1.xls"));
        workbook.close();
    }

    // 读取excel内容
    @Test
    public void read() throws Exception {
        // 根据excel文件流获取工作簿
        Workbook workbook = new HSSFWorkbook(new FileInputStream(filePath + "\\demo1.xls"));
        // 获取工作表
        Sheet sheet = workbook.getSheetAt(0);
        // 获取第一行
        Row row = sheet.getRow(0);
        // 获取第一行第一列
        Cell cell = row.getCell(0);
        // 获取单元格
        System.out.println("单元格内容：" + cell.getStringCellValue());
        System.out.println("总行数：" + sheet.getPhysicalNumberOfRows());
        System.out.println("总列数：" + row.getPhysicalNumberOfCells());

        workbook.close();
    }
}
