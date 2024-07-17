package com.qa.nimap.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.nimap.baseclass.BaseClass;
import com.qa.nimap.pages.AddCustomer;

public class AddCustomerTestCase extends BaseClass{

	public AddCustomerTestCase() throws IOException {
		super();
		
	}
	AddCustomer addCust;
	
	@BeforeMethod
	public void signUp() throws IOException, InterruptedException {
		initilization();
		LoginNimap(Props.getProperty("mobile_no"),Props.getProperty("password"));
		addCust = new AddCustomer();
	}
	
	
	@Test
	public void add_customer() throws InterruptedException {
		addCust.customerAdd();
	}
	@Test(dependsOnMethods="add_customer")
	public void verifyCust() {
		addCust.verifycustmoer();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
