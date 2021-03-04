package org.iit.healthcare.mmp.patientmodule.pages;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.iit.healthcare.mmp.HelperClass;
import org.iit.healthcare.mmp.Utility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PatRegistrationPage {

	private WebDriver driver;
	private HelperClass helperObj;
	private Random rand = new Random();

	WebDriverWait wait;
	int noOfChars = 5;
	int noOfDigitsZip = 5;
	int noOfDigitsAge = 2;

	// write methods to catch the error labels and send it again
	public PatRegistrationPage(WebDriver driver) {
		this.driver = driver;
		helperObj = new HelperClass(driver);
	}
	// Navigate to Registration Page
	public void clickRegisterButton() {
		driver.findElement(registerBtn).click();
	}

	HashMap<String, String> hMap = new HashMap<String, String>();
	
	By registerBtn = By.xpath("//input[@value='Register'] ");
	By firstNameTB = By.id("firstname");
	By lastNameTB = By.id("lastname");
	By DOBDate = By.id("datepicker");
	By licenseTB = By.id("license");
	By SSNTB = By.id("ssn");
	By stateTB = By.id("state");
	By cityTB = By.id("city");
	By addressTB = By.id("address");
	By zipCodeTB = By.id("zipcode");
	By ageTB = By.id("age");
	By heightTB = By.id("height");
	By weightTB = By.id("weight");
	By pharmacyTB = By.id("pharmacy");
	By pharmaAddressTB = By.id("pharma_adress");
	By emailIDTB = By.id("email");
	By userNameTB = By.id("username");
	By passwordTB = By.id("password");
	By confirmPasswordTB = By.id("confirmpassword");
	By securityIDTB = By.id("security");
	By answerTB = By.id("answer");
	By registerBtn2 = By.name("register");
	By ageValidMsg = By.xpath("");

	public void enterFirstName() {
		driver.findElement(firstNameTB).clear();
		String firstNameValue = "MatrixFName" + Utility.getRandomString(noOfChars);
		driver.findElement(firstNameTB).sendKeys(firstNameValue);
		hMap.put("Fname", firstNameValue);
	}

	public void enterLastName() {
		driver.findElement(lastNameTB).clear();
		String lastNameValue = "MatrixLName"+ Utility.getRandomString(noOfChars);
		driver.findElement(lastNameTB).sendKeys(lastNameValue);
		hMap.put("LName", lastNameValue);
	}

	public void enterDateOfBirth() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String datePickerValue = sdf.format(d);
		driver.findElement(DOBDate).sendKeys(datePickerValue);
		hMap.put("DatePicker", datePickerValue);
	}

	public void enterLicense() {
		driver.findElement(licenseTB).clear();
		String licenseValue = Integer.toString(getRandomNumber(10000000, 7));
		System.out.println("Entering License Value::" + licenseValue);
		driver.findElement(licenseTB).sendKeys(licenseValue);
		hMap.put("license", licenseValue);
	}

	public String enterSSN() {

		driver.findElement((By) SSNTB).clear();
		String ssnValue = Integer.toString(getRandomNumber(100000000, 8));
		System.out.println("Entering SSN Value::" + ssnValue);
		driver.findElement((By) SSNTB).sendKeys(ssnValue);

		if (ssnValue.isEmpty()) {
			return "Failed to Locate SSN inputbox";
		}
		;
		return hMap.put("ssn", ssnValue);
	}

	public int getRandomNumber(int limit, int digits) {
		Random rnd = new Random();
		String value = "";
		for (int i = 0; i < digits; i++) {
			value = value + "9";
		}
		int result = Integer.parseInt(value) + rnd.nextInt(limit);
		return result;
	}

	public void enterState() {

		String stateValue = "California";
		driver.findElement(stateTB).sendKeys(stateValue);
		hMap.put("State", stateValue);
	}

	public void enterCity() {
		String cityValue = "Los Angeles";
		driver.findElement(cityTB).sendKeys(cityValue);
		hMap.put("City", cityValue);
	}

	public void enterAddressValue() {
		String addressValue = "10 Ocean Avenue";
		driver.findElement(addressTB).sendKeys(addressValue);
		hMap.put("Address", addressValue);
	}

	public void enterZipCodeValue() {

		String zipCodeValue = Utility.getRandomNoofDigits(noOfDigitsZip) + "";
		driver.findElement(zipCodeTB).sendKeys(zipCodeValue);
		hMap.put("ZipCode", zipCodeValue);
	}

	public void enterAgeValue() {
		String ageValue = Utility.getRandomNoofDigitsAge(noOfDigitsAge) + "";

		driver.findElement(ageTB).sendKeys(ageValue);

		hMap.put("Age", ageValue);
	}

	public void enterHeightValue() {
		String heightValue = rand.nextInt(100) + "";
		driver.findElement(heightTB).sendKeys(heightValue);
		hMap.put("Height", heightValue);
	}

	public void enterWeightValue() {
		String weightValue = rand.nextInt(100) + "";
		driver.findElement(weightTB).sendKeys(weightValue);
		hMap.put("Weight", weightValue);

	}

	public void enterPharmaDetails() {

		String pharmacyValue = "MMP Pharmacy";
		driver.findElement(pharmacyTB).sendKeys(pharmacyValue);
		hMap.put("Pharma", pharmacyValue);

		String pharma_adressValue = "12 Chipmunk Crossing";
		driver.findElement(pharmaAddressTB).sendKeys(pharma_adressValue);
		hMap.put("PharmaAddress", pharma_adressValue);
	}

	public void enterUserDetails() {
		;
		driver.findElement(emailIDTB).clear();
		String emailValue = "MatrixMMPQA" + rand.nextInt(100) + "@gmail.com";
		driver.findElement(emailIDTB).sendKeys(emailValue);
		hMap.put("Email", emailValue);

		driver.findElement(userNameTB).clear();
		String usernameValue = "MatrixMMPQA" + rand.nextInt(100);
		driver.findElement(userNameTB).sendKeys(usernameValue);
		hMap.put("Username", usernameValue);
		System.out.println("Username is " + usernameValue);

		driver.findElement(passwordTB).clear();
		String passwordValue = "MatrixMMPQA" + rand.nextInt(100);
		driver.findElement(passwordTB).sendKeys(passwordValue);
		hMap.put("Password", passwordValue);
        System.out.println("Password is " + passwordValue);
		
		driver.findElement(confirmPasswordTB).clear();
		driver.findElement(confirmPasswordTB).sendKeys(passwordValue);
		hMap.put("ConfirmPassword", passwordValue);
	}

	public void enterSecurityInfo() {
		new Select(driver.findElement(securityIDTB)).selectByVisibleText("What is your mother maiden name");
		hMap.put("SecurityQuestion", "What is your mother maiden name");

		String answerValue = "WalesQA" + rand.nextInt(100);
		driver.findElement(answerTB).sendKeys(answerValue);
		hMap.put("SecurityAnswer", answerValue);

	}

	public void clickOnSaveButton() {
		driver.findElement(registerBtn2).click();
	}

	public String readSuccessMessage() throws InterruptedException {

		String msg = "";
		try {

			wait = new WebDriverWait(driver, 3000);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alert = driver.switchTo().alert();
			Thread.sleep(3000);
			msg = alert.getText();
			System.out.println("Alert msg:" + msg);
			alert.accept();
		} catch (NoAlertPresentException e) {

			e.printStackTrace();

		}
		return msg;

	}

	public String checkError() throws IOException {

		String msg = "";
		System.out.println("Inside the CheckError method");
		String errElement = "";
		List<WebElement> errElements = driver.findElements(By.tagName("p"));
		System.out.println("No. Of Error Elements Present " + errElements.size());
		for (WebElement webElement : errElements) {

			if (webElement.isDisplayed()) {

				System.out.println(webElement.getText());
				errElement = webElement.getAttribute("id");
				System.out.println(errElement);
				String xpath = "//p[@id='" + errElement + "']/preceding-sibling::input";
				if (webElement.getText().contains("license")) {
					helperObj.highLightElement(driver.findElement(By.xpath(xpath)));
					driver.findElement(By.xpath(xpath)).sendKeys("12345678");
					hMap.put("License", "12345678");
				}
			}
		}
		try {
			helperObj.highLightElement(driver.findElement(registerBtn2));
			driver.findElement(registerBtn2).click();
			Alert alert = driver.switchTo().alert();
			msg = alert.getText();
			alert.accept();
		} catch (Exception e) {
			System.out.println("Exception got: " + e.getMessage());

		}
		return msg;
	}

	// Verifying Current URL and Title of the page
	public String landingPageRedirection() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public String landingPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	public void fillData() {
		enterFirstName();
		enterLastName();
		enterDateOfBirth();
		enterLicense();
		enterSSN();
		enterState();
		enterCity();
		enterAddressValue();
		enterZipCodeValue();
		enterAgeValue();
		enterHeightValue();
		enterWeightValue();
		enterPharmaDetails();
		enterUserDetails();
		enterSecurityInfo();
		clickOnSaveButton();
	}
	
}
