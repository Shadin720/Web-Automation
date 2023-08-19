package com.TutorialsNinja.qa.Testcases;

//import java.time.Duration;
//import java.util.Date;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.TutorialsNinja.qa.Base.Base;
import com.TutorialsNinja.qa.utils.utilities;


public class Login extends Base {

	public Login() {
		super();
	}
	@BeforeMethod
	public void setup() {
		
		driver.findElement(By.linkText("Login")).click();
	}

	@Test(priority = 1, dataProvider="ValidCredentialsSupplier")
	public void verifyLoginWithValidCredentials(String email, String password) {

		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"Edit your account information is no displayed");

		
	}

	@Test(priority = 2)
	public void verifyLoginWithInvalidCredentials() {

		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailWithTimeStand());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		String actualwarningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		Assert.assertTrue(actualwarningMessage.contains(actualwarningMessage),
				" No match for E-Mail Address and/or Password");

	}

	@Test(priority = 3)
	public void verifyLoginWithInvalidEmailValidPassword() {
	
		driver.findElement(By.id("input-email")).sendKeys(utilities.generateEmailWithTimeStand());
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		String actualwarningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		Assert.assertTrue(actualwarningMessage.contains(actualwarningMessage),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 4)
	public void verifyLoginWithValidEmailInvalidPassword() {
	
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		String actualwarningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		Assert.assertTrue(actualwarningMessage.contains(actualwarningMessage),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 5)
	public void verifyLoginWithoutprovidinganycredentials() {
	
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		String actualwarningMessage = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]")).getText();
		Assert.assertTrue(actualwarningMessage.contains(actualwarningMessage),
				"Expected Warning Message is not displayed");

	}

	@Test(priority = 6)
	public void verifyForgottenPasswordLinkisAvailableInLoginPage() {
	
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Forgotten Password")).getText();

	}
	// Login TestData using Email And Password Hardcore

	
	  @DataProvider(name="validCredentialsSupplier") 
	  public Object[][] testData() {
	  Object[][] data = { { "Shadinmir720@gmail.com", "12345" }, {
	  "Shadinmir887@gmail.com", "12345" }, { "Shadinmir2@gmail.com", "12345" }, {
	  "Mirjisan4@gmail.com", "12345" }, { "Ishartjahanchamak@gmail.com", "12345" },
	  { "Khalidiqbal@gmail.com", "12345" }, { "pranto234@gmail.com", "12345" }, {
	  "ullash456@gmail.com", "12345" } }; return data; }
	 

//	@DataProvider(name = "validCredentialsSupplier")
//	public Object[][] supplyTestData() {
//
//		Object[][] data = utilities.getTestDataFromExcel("Login");
//		return data;
//	}

	@Test(priority = 7, dataProvider = "validCredentialsSupplier")
	public void TestData1 (String Email, String Password) {

		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.id("input-email")).sendKeys(Email);
		driver.findElement(By.id("input-password")).sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed(),
				"Edit your account information is no displayed");

	}
}
