package org.iit.healthcare.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {

	WebDriver driver;

	public HelperClass(WebDriver driver) {
		this.driver = driver;
	}


	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'" +moduleName+ "')]")).click();;
	}

}
