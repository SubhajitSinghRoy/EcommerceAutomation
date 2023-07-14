package com.TestComponents;

import com.pageObjects.CartPage;
import com.pageObjects.HomePage;
import com.pageObjects.LoginPage;
import com.pageObjects.OrderPage;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

	public WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static CartPage cartPage;
	public static OrderPage orderPage;

	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream("src/main/resources/GlobalData.properties");
		Properties prop = new Properties();
		prop.load(fis);

		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
				: prop.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver2.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		}

		else if (browser.equalsIgnoreCase("headless")) {

			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);

			driver.manage().window().setSize(new Dimension(1440, 900));// fullscreen above maximize
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}

		threadLocalDriver.set(driver);
		//return threadLocalDriver.get();
		return driver;
	}

	public LoginPage launchApp(WebDriver driver) {
		driver.get("https://rahulshettyacademy.com/client");

		return new LoginPage(driver);
	}

	@BeforeTest(alwaysRun = true) // to avoid giving each of the groups
	public void goToLoginPage() throws IOException {

		driver = initializeDriver();
		loginPage = launchApp(driver);
	}

	@AfterTest(alwaysRun = true) // to avoid giving each of the groups
	public void quitApplication() {
		driver.quit();
	}

	public String getScreenshot(String name, WebDriver driver) throws IOException {

		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);

		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File file = new File("C:\\Users\\Subha\\IdeaProjects\\EcommerceAutomation\\src\\main\\resources\\snapshots\\"
				+ name + ".png");
		FileUtils.copyFile(source, file);

		return "C:\\Users\\Subha\\IdeaProjects\\EcommerceAutomation\\src\\main\\resources\\snapshots\\" + name + ".png";

	}

}
