package com.qtpselenium.framework.datadriven.portfolio;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;
import com.qtpselenium.framework.datadriven.util.Utility;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class Test2 extends TestBase {
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="portfolioDataProvider")
	public void test2(Hashtable <String, String>table) throws IOException{
		
		validateRunmodes("Test2", Constants.PORTFOLIO_SUITE,table.get("Runmode"));	
		
		
		
	}
	
}
