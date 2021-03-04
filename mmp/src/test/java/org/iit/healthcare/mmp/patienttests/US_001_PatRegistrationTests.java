package org.iit.healthcare.mmp.patienttests;

import org.iit.healthcare.mmp.BaseClass;
import org.iit.healthcare.mmp.patientmodule.pages.PatRegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_001_PatRegistrationTests extends BaseClass{
 
	PatRegistrationPage RPPage;

	@Parameters({ "url" })
	@Test(priority=2, description = "Register with valid creds", groups = { "US_001", "regression", "sanity", "patientmodule" })
	public void validPatRegistration(String url) throws Exception {
		launchAppURL(url);

		// calling Registration page and its methods
		RPPage = new PatRegistrationPage(driver);
		RPPage.clickRegisterButton();
		RPPage.fillData();
		
		// Validation for Success Message
		String actual = RPPage.readSuccessMessage();
		System.out.println("Actual value:" + actual);
		String expected = "Thank you for registering with MMP. ";
		Assert.assertEquals(expected, actual);
		System.out.println("Successfully passed!");
	}
	@Parameters({ "url" })
	@Test(priority=3, description = "Verifying redirection to the landing page")
	public void validatelandingPageRedirectionTest() {
		RPPage = new PatRegistrationPage(driver);
		// Verifying redirection to the Home page from Registration page
		String expectedURL = "http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/";
		String actualURL = RPPage.landingPageRedirection();
		Assert.assertEquals(actualURL, expectedURL);

		// Validation for Current Title of Home Page
		String expectedTitle = "NAMTG";
		String actualTitle = RPPage.landingPageTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Successfully Title passed!");
	}
	
	
}
