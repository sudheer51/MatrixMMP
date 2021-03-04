package org.iit.healthcare.mmp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HelperClass {

	WebDriver driver;

	public HelperClass(WebDriver driver) {
		this.driver = driver;
	}


	public void navigateToAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(text(),'" +moduleName+ "')]")).click();;
	}

	public void highLightElement(WebElement ele) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;')", ele);

	}

	public static WebElement waitforElementClickable(WebDriver driver, long timeinSecs, By e) {
		WebDriverWait wait = new WebDriverWait(driver, timeinSecs);
		WebElement continueWE = wait.until(ExpectedConditions.elementToBeClickable(e));
		System.out.println("Webelement " + continueWE);
		return continueWE;
	}
}
