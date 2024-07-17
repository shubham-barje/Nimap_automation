package com.qa.nimap.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.nimap.baseclass.BaseClass;
import com.qa.nimap.pages.PunchIn;

public class PunchInTestCase extends BaseClass{
	public PunchInTestCase() throws IOException {
		super();
		
	}
	PunchIn pi;

	@BeforeMethod
	public void setUp() throws InterruptedException, IOException
	{
		initilization();
		LoginNimap(Props.getProperty("mobile_no"),Props.getProperty("password"));
		pi = new PunchIn();
	}
	@Test
	public void punchIn() throws InterruptedException {
		pi.punchIn();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
