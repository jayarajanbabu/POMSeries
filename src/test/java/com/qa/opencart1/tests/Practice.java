package com.qa.opencart1.tests;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {
	public static WebDriver driver;
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys("naveenanimation20@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("Selenium12345");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.name("search")).sendKeys("MacBook");
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		
		selectProduct("MacBook Pro");
		
//		driver.findElement(By.linkText("MacBook Pro")).click();
		Map<String, String> prodInfoMap = new LinkedHashMap<String,String>();
		List<WebElement> metaData = driver.findElements(By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li"));
		for(WebElement e:metaData) {
			String text = e.getText();
			String meta[] = text.split(":");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			prodInfoMap.put(metaKey, metaValue);
		}
		prodInfoMap.forEach((k,v) -> System.out.println(k+":"+v));
	}
	
	public static void selectProduct(String mainProductName) {
		System.out.println("Main Product Name is : "+mainProductName);
		List<WebElement> searchResult = driver.findElements(By.cssSelector("div.caption a"));
		for (WebElement e: searchResult) {
			String text = e.getText();
			if (text.equals(mainProductName)) {
				e.click();
				break;
			}
		}
	}

}
