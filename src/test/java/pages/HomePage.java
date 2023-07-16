package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends CommonUtils {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }




    public void selectItemfromCart(List<String> itemnames) {

        for (int i = 0; i < itemnames.size(); i++) {

            WebElement itemForCart = driver.findElement(By.xpath("(//b[contains(text(),'"
                    + itemnames.get(i) + "')]//parent::h5//following-sibling::button)[2]"));

            itemForCart.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);

            waitForElementToAppear(By.id("toast-container"));
            waitForElementToDisappear(By.id("toast-container"));
        }

    }


    public void selectItemfromCart(String itemname) {



            WebElement itemForCart = driver.findElement(By.xpath("(//b[contains(text(),'"
                    + itemname + "')]//parent::h5//following-sibling::button)[2]"));

            itemForCart.click();
            WebDriverWait wait = new WebDriverWait(driver, 5);

            waitForElementToAppear(By.id("toast-container"));
            waitForElementToDisappear(By.id("toast-container"));


    }


}