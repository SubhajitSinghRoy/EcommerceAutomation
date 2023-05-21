package com.pageObjects;

import com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends AbstractComponent {

    WebDriver driver;

    @FindBy(xpath="//h1[@class]")
    WebElement successMessage;

    public SuccessPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public String returnSuccessMessage(){

        return this.successMessage.getText();

    }


}
