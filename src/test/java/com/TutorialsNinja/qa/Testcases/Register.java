package com.TutorialsNinja.qa.Testcases;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.TutorialsNinja.qa.Base.Base;
import com.TutorialsNinja.qa.utils.utilities;

//import com.TutorialsNinja.qa.utils.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register extends Base {
	@BeforeMethod
	public void setup() {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys(dataProp.getProperty("firstName"));

		driver.findElement(By.id("input-lastname")).sendKeys(dataProp.getProperty("lastName"));

	}

	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(dataProp.getProperty("password"));

		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		// confirm xpath "//*[@id="content"]/h1"

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());
	}
	
	
	
	

	@Test(priority = 2)
	public void verifyRegisteringAnAccountByProvidingAllTheFieldsWhenYes() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.name("newsletter")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());

	}

	@Test(priority = 3)
	public void verifyRegisteringAnAccountByProvidingAllTheFieldsWhenNo() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());

	}

	@Test(priority = 4)
	public void verifyRegisteringAnAccountByEnteringDiffererentPasswordField() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")).isDisplayed());

	}

	@Test(priority = 5)
	public void verifyRegisteringAnAccountByProvidingTheExistingAccountDetails() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed());

	}

	@Test(priority = 6)
	public void verifyRegisteringAnAccountByInvalidEmailAddressIntoTheEmailField() {

		driver.findElement(By.name("email")).sendKeys(utilities.generateEmailWithTimeStand());
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed(), "accountcreated");

	}

	@Test(priority = 7)
	public void verifyRegisteringAnAccountByInvalidPhoneNumberIntoThePhoneNumberField() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.name("telephone")).sendKeys(utilities.generateEmailWithTimeStand());
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).isDisplayed(), "accountcreated");

	}

	@Test(priority = 8)
	public void verifyWheterThePrivacyPolicyCheckboxOptionIsNotSelectedByDedault() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("confirm")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]")).isDisplayed(),
				"accountcreated");

	}

	@Test(priority = 9)
	public void VerifyRegistringAnAccountByFillingPasswordFieldAndNotFillingPasswordConfirmField() {

		driver.findElement(By.name("email")).sendKeys(prop.getProperty("validUserName"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataProp.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(dataProp.getProperty("password"));
		driver.findElement(By.id("input-confirm")).sendKeys("");

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(
				driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")).isDisplayed(),
				"accountcreated");

	}

	@Test(priority = 10)
	public void verifyRegisteringWithoutAnyField() {
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		driver.findElement(By.id("input-firstname")).sendKeys("");
		driver.findElement(By.id("input-lastname")).sendKeys("");
		driver.findElement(By.name("email")).sendKeys("");
		driver.findElement(By.name("telephone")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.id("input-confirm")).sendKeys("");

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"account\"]/div[2]/div/div")).isDisplayed(),
				"accountcreated");

	}

}
