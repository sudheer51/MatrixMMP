package org.iit.healthcare.mmp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	protected WebDriver driver; 
	
	@BeforeClass
	public void intantiateDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	/**
	 * 
	 * @param url
	 */
	public void launchAppURL(String url)
	{
		driver.get(url);
		driver.manage().window().maximize();
	}
}
