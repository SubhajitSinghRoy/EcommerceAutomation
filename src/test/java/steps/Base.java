package steps;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.URL;

import pages.CartPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderPage;
import pages.SuccessPage;
import support.Constant;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

	public WebDriver driver;
	public static LoginPage loginPage;
	public static HomePage homePage;
	public static CartPage cartPage;
	public static OrderPage orderPage;
	public static CheckOutPage checkOutPage;
	public static SuccessPage successPage;
	public static Properties prop;

	ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
	ThreadLocal<LoginPage> threadLocalLoginPage = new ThreadLocal<>();

	public WebDriver initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(Constant.GLOBAL_PROPERTY_FILE_PATH);
		prop = new Properties();
		prop.load(fis);

//		String browser = System.getProperty("browser") != null ? System.getProperty("browser")
//				: prop.getProperty("browser");

		String browser = prop.getProperty("browser");

		if (browser.equalsIgnoreCase("grid")) {

			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setBrowserName("chrome");
			caps.setPlatform(Platform.ANY);
			driver = new RemoteWebDriver(new URL(Constant.GRID_URL), caps);
			
		}

		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_FILE_PATH);
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", Constant.GECKODRIVER_FILE_PATH);
			driver = new FirefoxDriver();

		}

		else if (browser.equalsIgnoreCase("headless")) {

			System.setProperty("webdriver.chrome.driver", Constant.CHROMEDRIVER_FILE_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			driver = new ChromeDriver(options);
		}

		threadLocalDriver.set(driver);
		// driver.manage().window().setSize(new Dimension(1440, 900));// fullscreen
		// above maximize
		threadLocalDriver.get().manage().window().maximize();
		threadLocalDriver.get().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		threadLocalDriver.get().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

		return threadLocalDriver.get();
		// return driver;
	}

	public LoginPage launchApp(WebDriver driver) {
		driver.get(prop.getProperty("url"));
		threadLocalLoginPage.set(new LoginPage(driver));
		return threadLocalLoginPage.get();
	}

//	@BeforeTest(alwaysRun = true) // to avoid giving each of the groups
//	public void goToLoginPage() throws IOException {
//
//		driver = initializeDriver();
//		loginPage = launchApp(driver);
//	}

	public void quitApplication() {

		threadLocalDriver.remove();
		driver.close();
	}

	public String getScreenshot(String name, WebDriver driver) throws IOException {

		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);

		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "\\src\\main\\resources\\snapshots\\" + name + ".png");
		FileUtils.copyFile(source, file);

		return System.getProperty("user.dir") + "\\src\\main\\resources\\snapshots\\" + name + ".png";

	}

}
