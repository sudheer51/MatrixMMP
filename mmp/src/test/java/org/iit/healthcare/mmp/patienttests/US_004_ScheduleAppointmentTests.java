package org.iit.healthcare.mmp.patienttests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.patientmodule.pages.LoginPage;
import org.iit.healthcare.mmp.patientmodule.pages.ScheduleAppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class US_004_ScheduleAppointmentTests extends BaseClass {
	 
	 
	 
	@Parameters({"url","moduleName","uname","pword","doctorName"})
	@Test(description="TC_001 Executing the Schedule Appointment",groups={"functest","sanity","regression","US_004"})
	public void scheduleAppointmentTest(String url,String moduleName,String uname,String pword,String doctorName)
	{
		launchAppURL(url);
		LoginPage lPage= new LoginPage(driver);
		String actual   =   lPage.login(uname,pword);
		
		String expected =  uname;
		Assert.assertEquals(actual,expected);
		HelperClass helperObj = new HelperClass(driver);
		helperObj.navigateToAModule(moduleName);
		
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		boolean result = sPage.validateScheduleApptDatainHomePage(doctorName);
		Assert.assertTrue(result);
		
////		WebDriverWait wait = new WebDriverWait(driver, 10);
////		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[text()='Dr.Becky']/ancestor::td/button[@id='opener']")));
////		driver.findElement(By.xpath("//h4[text()='Dr.Becky']/ancestor::td/button[@id='opener']")).click();
////		
//				td[1]: Date
//				td[2]: Time
//				td[3]: Sym
//				td[4]: Beth
		
	}

}
