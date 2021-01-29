package org.iit.healthcare.mmp.patientmodule.pages;

import java.util.HashMap;
import java.util.List;

import org.iit.healthcare.mmp.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScheduleAppointmentPage {

	WebDriver driver;
	By createAppointment = By.xpath("//input[@value='Create new appointment']");
	By datePicker = By.id("datepicker");
	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public HashMap<String, String> scheduleAppointment(String doctorName)
	{
		driver.findElement(createAppointment).click();
		HashMap<String,String> sAppointmentHMap = new HashMap<String,String>();
		sAppointmentHMap.put("doctor",doctorName);
		driver.findElement(By.xpath("//h4[text()='Dr."+doctorName+"']/ancestor::td/button[@id='opener']")).click();
		driver.switchTo().frame("myframe");
		String dateofAppointment=Utility.getFutureDate(5);
		sAppointmentHMap.put("date", dateofAppointment);
		driver.findElement(datePicker).sendKeys(dateofAppointment);
		driver.findElement(By.xpath("//body")).click();
		Select select = new Select(driver.findElement(By.id("time")));
		String time="10Am";
		sAppointmentHMap.put("time", time);
		select.selectByVisibleText(time);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement continueButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ChangeHeatName")));
		continueButton.click();
		String sym="Fever and Cold";
		sAppointmentHMap.put("sym", sym);
		driver.findElement(By.id("sym")).sendKeys(sym);
		driver.findElement(By.xpath(("//input[@value='Submit']"))).click();
		return sAppointmentHMap;
	}
	public boolean validateScheduleApptDatainHomePage(String doctorName)
	{
		HashMap<String,String> sAppointmentHMap = scheduleAppointment(doctorName);
		 
		List<WebElement> tdList=driver.findElements(By.xpath("//table[@class='table']/tbody/tr[1]/td"));
		boolean result = false;
		if(sAppointmentHMap.get("date").equals(tdList.get(0).getText())&&
		   sAppointmentHMap.get("time").equals(tdList.get(1).getText()) &&
		   sAppointmentHMap.get("sym").equals(tdList.get(2).getText()) &&
		   sAppointmentHMap.get("doctor").equals(tdList.get(3).getText()))
		{
			
			result = true;
		}
		return result;
	}
}
