package com.qtpselenium.framework.datadriven.portfolio;

import java.util.Hashtable;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;
import com.qtpselenium.framework.datadriven.util.Utility;
import com.qtpselenium.framework.datadriven.util.Xls_Reader;

public class LoginTest extends TestBase{
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="PortfolioDataProvider")
	public void loginTest(Hashtable<String,String> table) throws InterruptedException{
		APPLICATION_LOG.debug("Executing test1");
		validateRunmodes("loginTest", Constants.PORTFOLIO_SUITE, table.get("Runmode"));
		
		doLogin(table.get(Constants.BROWSER_COL), table.get(Constants.USERNAME_COL), table.get(Constants.PASSWORD_COL));
		//validation for login
		boolean signoutLink=isElementPresent("signout_Xpath");
		if(!(((table.get(Constants.EXPECTEDRESULT_COL).equals("SUCCESS")) && signoutLink)))
				Assert.fail("Not able to login with correct credentials");			
		else if(table.get(Constants.EXPECTEDRESULT_COL).equals("FAILURE")){
			if(signoutLink){
				Assert.fail("Logged in with wrong credentials");			
			}
		}
				
		
		
	}
	@AfterMethod
	public void close(){
		quit();
	}
	
}
