package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage extends CommonUtils {

    WebDriver driver;

    @FindBy(xpath = "//a[text()='Place Order ']")
    WebElement orderBtn;

    @FindBy(xpath = "//input[@placeholder]")
    WebElement selectCountryTxtBox;


    public CheckOutPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillCountryName(String name) throws InterruptedException {

    	name="india";
        Actions actions = new Actions(this.driver);
        javaScriptExecutorClick(this.selectCountryTxtBox);
        actions.sendKeys(this.selectCountryTxtBox, name).build().perform();
        hardWait(3000);
        List<WebElement> names=driver.findElements(By.xpath("//section//button//span"));
        
        
        for (WebElement countryName : names)
        {
        	System.out.println(countryName.getText().trim().toLowerCase());
        	if (countryName.getText().trim().toLowerCase().equals(name.toLowerCase()))
        	
        	javaScriptExecutorClick(countryName);
        }
       
    }

    public SuccessPage orderItems(){

        this.orderBtn.click();
        return new SuccessPage(driver);
    }
}
