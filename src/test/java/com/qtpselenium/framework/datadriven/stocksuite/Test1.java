package com.qtpselenium.framework.datadriven.stocksuite;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;
import com.qtpselenium.framework.datadriven.util.Utility;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class Test1 extends TestBase{
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteBDataProvider")
	public void test1(Hashtable <String, String>table) throws IOException{
		APPLICATION_LOG.debug("Executing Test1");
		
		
	/*	Xls_Reader xls = new Xls_Reader("F:\\newmodule20xlsfiles\\Suite.xlsx");
		System.out.println (Utility.isSuiteRunnable("SuiteA", xls));
		System.out.println (Utility.isSuiteRunnable("SuiteB", xls));
		System.out.println (Utility.isSuiteRunnable("SuiteC", xls));
		
		System.out.println("-------------------");
		
		Xls_Reader	 xls1 = new Xls_Reader("F:\\newmodule20xlsfiles\\SuiteA.xlsx");
	System.out.println(Utility.isTestCaseRunnable("Test1", xls1));	
	System.out.println(Utility.isTestCaseRunnable("Test2", xls1));	
	System.out.println(Utility.isTestCaseRunnable("Test3", xls1));	
	System.out.println(Utility.isTestCaseRunnable("Test4", xls1));	
	System.out.println(Utility.isTestCaseRunnable("Test5", xls1));	
	*/
		
	validateRunmodes("Test2", Constants.SECOND_SUITE,table.get("Runmode"));	
	
	}
	
	
}
