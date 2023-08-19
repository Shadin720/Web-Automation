package com.TutorialsNinja.qa.Base;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver = null;
	public Properties prop;
	private static String propFile = "configuration/config.properties";
	public Properties dataProp;
	private static String dataPropFile = "testdata/testdata.properties";
	public Base() {
		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\TutorialsNinja\\config\\config.properties");
		
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\Tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis =new FileInputStream(dataPropFile);
		dataProp.load(datafis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		} catch (Throwable e) {
			e.printStackTrace();

		}

	}

	@BeforeMethod
	public void setUpMethod() {

//		String browserName ="chrome";              ( for browserSetUp)
//		if(browserName.equals("chrome")) {
//			
//			driver=new ChromeDriver();
//		}
//		else if (browserName.equals("firefox")) {
//			driver =new FirefoxDriver();
//			
//		} else if(browserName.equals("edge")) {
//			driver = new EdgeDriver();
//		}

		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]")).click();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
