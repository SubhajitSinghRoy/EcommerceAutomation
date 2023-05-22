package com.pageObjects;

import com.AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class OrderPage extends AbstractComponent {

    WebDriver driver;
@FindBy(xpath="(//img//parent::td//following-sibling::td[1])")
List<WebElement> orderItems;



    public OrderPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
public boolean validateOrders(List<String> items) throws InterruptedException {

    List<String> orderlist=null;
    hardWait(10000);
    System.out.println("the size of items is "+orderItems.size());
    for (int i=0;i<orderItems.size();i++)
    {
        System.out.println(orderItems.get(i).getText());
        orderlist.add(orderItems.get(i).getText());
        hardWait(5000);
    }
    return orderItems.equals(items);
}
}
