package com.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class StandAloneTests {

    WebDriver driver;


    @Test
    public void login() {


        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/client");

        driver.findElement(By.id("userEmail")).sendKeys("testingsubhajit220@gmail.com");

        driver.findElement(By.id("userPassword")).sendKeys("Aug@1234");
        driver.findElement(By.id("login")).click();

        driver.quit();

    }


}
