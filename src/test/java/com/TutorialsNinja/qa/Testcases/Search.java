package com.TutorialsNinja.qa.Testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.TutorialsNinja.qa.Base.Base;

public class Search extends Base {
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys("iphone");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		driver.findElement(By.linkText("iPhone"));
		Assert.assertTrue(driver.findElement(By.linkText("iPhone")).isDisplayed());

	}

	@Test(priority = 2)
	public void verifySearchWithinvalidProduct() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys("CBR");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed(),
				"There is no product that matches the search criteria");

	}

	@Test(priority = 3)
	public void VerifySearchWithoutAnyProduct() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/h2"));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed(),
				"There is no product that matches the search criteria");

	}

	@Test(priority = 4)
	public void verifySearchWithUsingSearchCriteria() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.id("input-search")).sendKeys("iphone");
		driver.findElement(By.name("category_id")).sendKeys("Phones & PDAs");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		Assert.assertTrue(driver.findElement(By.linkText("iPhone")).isDisplayed());

	}

	@Test(priority = 5)
	public void verifySearchUsingTheTextFromTheProductDescription() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		driver.findElement(By.id("description"));
		driver.findElement(By.id("input-search")).sendKeys(
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o..");
		driver.findElement(By.name("category_id")).sendKeys("Phones & PDAs");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed());

	}
@Test(priority=6)
	public void verifySearchBySelectingSubCategory() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.name("search")).sendKeys("iphone ");
		driver.findElement(By.name("category_id")).sendKeys("Phones & PDAs");
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/label/input"));
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed());

	}

	@Test(priority = 7)
	public void verifySearchUsingPageUrl() {
		driver.get("https://tutorialsninja.com/demo/index.php?route=product/search");
		driver.findElement(By.id("description"));
		driver.findElement(By.id("input-search")).sendKeys(
				"iPhone is a revolutionary new mobile phone that allows you to make a call by simply tapping a name o..");
		driver.findElement(By.name("category_id")).sendKeys("Phones & PDAs");
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button/i"));
		driver.findElement(By.xpath("//*[@id=\"button-search\"]")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed());
	}

}
