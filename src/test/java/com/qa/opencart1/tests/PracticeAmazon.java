package com.qa.opencart1.tests;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PracticeAmazon {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("MacBook Pro");
		driver.findElement(By.id("nav-search-submit-button")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Apple 13.3\" MacBook Pro with Touch Bar, Intel Core i5 Quad-Core, 8GB RAM, 128GB SSD - Mid 2019, Space Gray, MUHN2LL/A (Renewed)')]")).click();
		driver.findElement(By.linkText("See more")).click();
		List<WebElement> prodInfo = driver.findElements(By.xpath("//table[@class='a-normal a-spacing-micro']//td"));
		Map<String, String> prodInfoMap = new LinkedHashMap<String, String>();
		for (WebElement e:prodInfo) {
			String text = e.getText();
			String meta[]=text.split("");
			String metaKey = meta[0].trim();
			String metaValue = meta[1].trim();
			prodInfoMap.put(metaKey, metaValue);
		}
		prodInfoMap.forEach((k,v)->System.out.println(k+" : "+v));
	}
}
