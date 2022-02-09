package com.flipkart.utils;

import org.testng.SkipException;

public class ExecutionRequired {

	/*
	 * Function To check For the Execution Required  
	 * fields for the particular Test in the Excel Sheet if yes proceed else Skip
	 */
	
	public  static  void checkExecutionRequired(String value)
	{
		if (value.toLowerCase().equalsIgnoreCase("no"))
		throw new SkipException("Skipping this Test Case as The Execution is Not Required");
	}

}
