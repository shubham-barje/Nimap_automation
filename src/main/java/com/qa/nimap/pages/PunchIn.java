package com.qa.nimap.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.nimap.baseclass.BaseClass;

public class PunchIn extends BaseClass{
	public PunchIn() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//span[@class=\"mat-button-wrapper\"])[3]")WebElement punchIn_btn;
	
	public void punchIn() throws InterruptedException {
		punchIn_btn.click();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		Thread.sleep(3000);
	}
}
