package org.demo;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandling {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 16");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
		driver.findElement(By.xpath("(//span[contains(text(), 'iPhone 16 12')])[5]")).click();
		Set<String> allId = driver.getWindowHandles();
		System.out.println(allId);

		int count = 1;
		for (String child : allId) {
			if (count == 2) {
				driver.switchTo().window(child);
			}
			count++;
		}
		driver.findElement(By.xpath("(//input[@title='Add to Shopping Cart'])[2]")).click();
	}
}
