package com.Products;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Getting_Prducts_Details {

	public static void main(String args[]) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./Browser/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, 10);

		WebElement Search_Box = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		Search_Box.sendKeys("iphone");

		WebElement Submit_Button = driver.findElement(By.xpath("//input[@id=\'nav-search-submit-button\']"));
		Submit_Button.click();

		String parentHandle = driver.getWindowHandle();
// 		System.out.println(parentHandle);

// 		System.out.println("before click");
		WebElement Apple_Mobile = driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']/span"));
		Apple_Mobile.click();
		

// 		System.out.println("after click");

		Set<String> handles = driver.getWindowHandles();

// 		int count = handles.size();
// 		System.out.println(count);

		for (String child : handles) {

			if (!parentHandle.equalsIgnoreCase(child)) {

// 				System.out.println("Inside loop");

				driver.switchTo().window(child);

				WebElement Mobile_Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='productTitle']")));
				String mobile_name = Mobile_Name.getText();
				System.out.println(mobile_name);

				WebElement Mobile_Price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='newAccordionRow']//span[@class='a-color-price']")));
				String mobile_price = Mobile_Price.getText();
				System.out.println(mobile_price);

				driver.close();

				driver.switchTo().window(parentHandle);

				driver.navigate().to("https://www.amazon.in/");

				WebElement Fashion_Click = driver.findElement(By.xpath("//div[@id='nav-xshop']//a[@href='/gp/browse.html?node=6648217031&ref_=nav_cs_fashion']"));
				Fashion_Click.click();

				driver.findElement(By.linkText("Men")).click();
				
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,3500)", "");

				WebElement Mens_Product_Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']")));
				String mens_product_name = Mens_Product_Name.getText();
				System.out.println(mens_product_name);

				WebElement Mens_Product_Price = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-price-whole']")));
				String mens_product_price = Mens_Product_Price.getText();
				System.out.println(mens_product_price);

				
				
				  com.Connect_Database.Database_Connect.DBConnect(); //
				  com.Create_Tables.Table_Create.Create_Table();
				  InsertDataInTable.InsertData(mobile_name,mobile_price);
				  InsertDataInTable.InsertData(mens_product_name,mens_product_price);
				 
				 

			  driver.quit();

			}
		}
	}
}
