package com.TestComponents;

import com.pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    WebDriver driver;

    public WebDriver initializeDriver() throws IOException {

        FileInputStream fis = new FileInputStream("src/main/resources/GlobalData.properties");
        Properties prop = new Properties();
        prop.load(fis);

        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {


            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            return driver;
        }
        else return driver;
    }

    public LoginPage launchApp(WebDriver driver){
        driver.get("https://rahulshettyacademy.com/client");

        return new LoginPage(driver);
    }

}
