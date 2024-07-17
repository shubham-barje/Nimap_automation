package com.qa.nimap.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.nimap.baseclass.BaseClass;

public class AddCustomer extends BaseClass{

	public AddCustomer() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//*[@id=\"kt_aside_menu\"]/ul/li[2]/a") WebElement my_customer;
	@FindBy(xpath="//button[@class=\"mat-button-mt-4 mat-raised-button mat-button-base mat-primary ng-star-inserted\"]") WebElement new_customer_btn;
	
	@FindBy(xpath="//input[@id=\"mat-input-14\"]") WebElement LeadCustomerName;
	@FindBy(xpath="//input[@id=\"mat-input-15\"]") WebElement RefNumber;
	@FindBy(xpath="//*[@id=\"mat-select-14\"]/div/div[1]/span") WebElement Country;
	@FindBy(xpath="//*[@id=\"mat-input-20\"]") WebElement searchCountry;
	@FindBy(xpath="(//*[contains(text(),\"India\")])[2]")WebElement selection;
	@FindBy(xpath="(//span[@class=\"mat-button-wrapper\"])[24]") WebElement save_btn;
	
	@FindBy(xpath="(//span[@class=\"kt-menu__link-text ng-star-inserted\"])[46]")WebElement Settings;
	@FindBy(xpath="(//span[@class=\"kt-menu__link-text ng-star-inserted\"])[47]")WebElement all_users;
	
	public void customerAdd() throws InterruptedException {
		my_customer.click();
		new_customer_btn.click();
		
		LeadCustomerName.sendKeys("Jatin Sapru");
		RefNumber.sendKeys("675");
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,70)");
		Country.click();
		searchCountry.sendKeys("India");
		selection.click();
		save_btn.click();
		Thread.sleep(3000);
		
		
		
	}
	public void verifycustmoer() {
//		JavascriptExecutor jse1 = (JavascriptExecutor)driver;
//		jse1.executeScript("window.scrollBy(0,500)");
		Settings.click();
		all_users.click();
	}
}
