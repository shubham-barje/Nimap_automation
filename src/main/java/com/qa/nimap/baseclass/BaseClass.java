package com.qa.nimap.baseclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	public static Properties Props;
	
	public BaseClass() throws IOException {
		try {
			Props = new Properties();
			FileInputStream fis = new FileInputStream("D:\\nimapinfotech\\nimap_autmation\\src\\main\\java\\com\\qa\\nimap\\config\\config.properties");
			Props.load(fis);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initilization() {
		String browserName = Props.getProperty("browser");
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(Props.getProperty("url"));
		
	}
	
	public void LoginNimap(String phone_no,String password) throws InterruptedException {
		driver.findElement(By.xpath("//input[@id=\"mat-input-0\"]")).sendKeys(phone_no);
		driver.findElement(By.xpath("//input[@id=\"mat-input-1\"]")).sendKeys(password);
		Thread.sleep(10000);
		System.out.println("Solve the Captcha and press Enter to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id=\"kt_login_signin_submit\"]")).click();
	}
}
