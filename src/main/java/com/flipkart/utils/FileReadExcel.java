package com.flipkart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class FileReadExcel {
	

	
	@SuppressWarnings("resource")
	public void readExcel(String path) throws IOException
	{	XSSFWorkbook data = null;
		File fs= new File(path);
		FileInputStream fis = new FileInputStream(fs);
		String filename = FilenameUtils.getName(path);
		if (filename.substring(filename.indexOf(".")).equals(".xlx"))
		{
			
		}
		data = new XSSFWorkbook(fis);
		XSSFSheet sh1=  data.getSheetAt(0);
		int rowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();
	    for (int i = 0; i < rowCount+1; i++) {
	        Row row = sh1.getRow(i);
	        for (int j = 0; j < row.getLastCellNum(); j++) {
	            System.out.print(row.getCell(j).getStringCellValue()+"|| ");
	        }
	        System.out.println();
	    } 
		}

	
	public static void main(String[] args) throws IOException {
		FileReadExcel a = new FileReadExcel();
		a.readExcel(".\\Resources\\TestCasesFile.xlsx");
	}
}
