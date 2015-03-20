package com.qtpselenium.framework.datadriven.stocksuite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qtpselenium.framework.datadriven.TestBase;
import com.qtpselenium.framework.datadriven.util.Constants;
import com.qtpselenium.framework.datadriven.util.ErrorUtil;
import com.qtpselenium.framework.datadriven.util.TestDataProvider;

public class AddStock extends TestBase{
	@BeforeTest
	public void initLogs(){
		initLogs(this.getClass());
	}
	
	@Test(dataProviderClass=TestDataProvider.class,dataProvider="suiteBDataProvider")
	public void addStock(Hashtable<String,String> table) throws InterruptedException{
		
		validateRunmodes("addStock", Constants.SECOND_SUITE, table.get("Runmode"));
		doDefaultLogin(table.get("Browser"));
		
		try{
		Assert.assertTrue(verifyTitle("loginPageTitle"), "Titles did not match");
		}catch(Throwable t){
			ErrorUtil.addVerificationFailure(t);
		}
		
		
		
		WebElement button=driver.findElement(By.xpath("html/body/div[3]/div/div/b/div[2]/div[1]/div[1]/div/input"));
		System.out.println("****");
		System.out.println(button.isDisplayed()+" --- "+button.isEnabled());
		
		
		click("addStock_xpath");
		driver.findElement(By.xpath(prop.getProperty("addStock_xpath"))).sendKeys(Keys.ENTER);
		//input("stockName", table.get("Stock Name"));
		Thread.sleep(5000);
		click("calendar_xpath");
		String date=table.get("PurchaseDate");
		
		Date currentDate = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date dateToBeSelected =null;
		try {
			 dateToBeSelected = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String month=new SimpleDateFormat("MMMM").format(dateToBeSelected);		
		Calendar cal = Calendar.getInstance();
	    cal.setTime(dateToBeSelected);
	    int year = cal.get(Calendar.YEAR);
	    int day = cal.get(Calendar.DAY_OF_MONTH);
	    String month_yearExpected = month+" "+year;
	    
		while(true){
			
			String month_yearDisplayed = getText("monthAndYearText_xpath");
			if(month_yearDisplayed.equals(month_yearExpected))
				break; // correct month
			
			if(currentDate.after(dateToBeSelected))
				click("calBack_xpath");
			else
				click("calFront_xpath");
		}
		
		driver.findElement(By.xpath("//td[text()='"+day+"']")).click();
		
		
		
	}
	@AfterMethod
	public void close(){
		quit();
	}
	
	
	

}
