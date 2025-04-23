package com.sjj.Plugintest;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ExcelTest {
    @Test
    public void testexcel() {
        XSSFWorkbook workbook = new XSSFWorkbook();
        System.out.println("Excel 文件创建成功！");
    }
}