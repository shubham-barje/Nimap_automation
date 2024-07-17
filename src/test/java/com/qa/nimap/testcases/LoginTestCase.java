package com.qa.nimap.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.nimap.baseclass.BaseClass;
import com.qa.nimap.pages.LoginPage;

public class LoginTestCase extends BaseClass{
	
	public LoginTestCase() throws IOException {
		super();
	}
	
	LoginPage lp;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		initilization();
		lp = new LoginPage();
		
		
	}
	
	@Parameters({"mobile_no","password"})
	@Test
	public void LoginNimap(String mobile_no,String password) throws InterruptedException {
		lp.Login(mobile_no, password);
//		lp.Login(Props.getProperty("moile_no"), Props.getProperty("password"));
	}
	
	@AfterMethod
	public void dearDown() {
		driver.quit();
	}
}
