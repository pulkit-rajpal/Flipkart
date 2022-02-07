package com.flipkart.utils;

import org.testng.SkipException;

public class ExecutionRequired {

	public  static  void checkExecutionRequired(String value)
	{
		if (value.toLowerCase().equalsIgnoreCase("no"))
		throw new SkipException("Skipping this Test Case as The Execution is Not Required");
	}

}
