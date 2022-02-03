package com.flipkart.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

public class FileReadExcel {
	public String name;
	public String mobNo;
	public String pwd;
	public String nameval;
	public String mob;
	public String pin;
	public String invalidpin;
	public String ad1;
	public String ad2;
	public String cty;
	public String st;

	public static FileReadExcel getData() throws IOException, EncryptedDocumentException, InvalidFormatException {
		InputStream file = new FileInputStream(new File(".\\Resources\\TestCasesFile.xlsx"));
		List<FileReadExcel> testData = ExcelToPojoUtils.toPojo(FileReadExcel.class, file);
		return testData.get(0);
	}

}

class TestData {
}
