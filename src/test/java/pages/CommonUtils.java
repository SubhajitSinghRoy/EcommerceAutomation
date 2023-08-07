package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils {

    WebDriver driver;

   

    @FindBy(xpath = "(//button[@class='btn btn-custom'])[3]")
    WebElement cartBtn;

    @FindBy(xpath="//*[contains(text(),'ORDERS')]")
    WebElement orderBtn;

    @FindBy(xpath = "//*[contains(text(),'Sign Out')]")
    WebElement logOutBtn;

    public CommonUtils(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    // this method is kept in CommonUtils as it is common for many pages

    public CartPage clickCartButton() {
        this.cartBtn.click();
        ThreadLocal<CartPage> cartPageThreadLocal= new ThreadLocal<>();
        cartPageThreadLocal.set( new CartPage(driver));
        return cartPageThreadLocal.get();
    }

    public OrderPage clickOrderBtn()
    {
    javaScriptExecutorClick(this.orderBtn);
    ThreadLocal<OrderPage> orderPageThreadLocal = new ThreadLocal<>();
    orderPageThreadLocal.set(new OrderPage(driver));
        return orderPageThreadLocal.get();
    }

    public static void hardWait(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public void waitForElementToAppear(By byLocator){
        WebDriverWait wait=  new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));

    }

    public void waitForElementToDisappear(By byLocator){

        WebDriverWait wait = new WebDriverWait(driver,5);
           wait.until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
    }

    public void waitForWebElementToAppear(WebElement webElement){

        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void javaScriptExecutorClick(WebElement element){

        JavascriptExecutor js =(JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        js.executeScript("arguments[0].click();", element);
    }

    public LoginPage logOutBtnClick() throws InterruptedException {
        javaScriptExecutorClick(this.logOutBtn);
        hardWait(3000);
        ThreadLocal<LoginPage> threadLoginpage= new ThreadLocal<>();
        threadLoginpage.set(new LoginPage(driver));
        return threadLoginpage.get();
    }


}
