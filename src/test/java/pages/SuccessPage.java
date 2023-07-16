package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SuccessPage extends CommonProperties {

    WebDriver driver;

    @FindBy(xpath="//h1[@class]")
    WebElement successMessage;

    @FindBy(xpath="//div[@class='title']")
    List<WebElement> itemList;

    public List<String> actualItems=null;

    public SuccessPage(WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }


    public String returnSuccessMessage(){

        return this.successMessage.getText();

    }
    
    public List<String> itemListSuccessPage() throws InterruptedException {
        
        List<String> items = new ArrayList<>();
        hardWait(4000);

        for (int i=0;i<itemList.size();i++){
          items.add(itemList.get(i).getText());
        }

       actualItems=
               items.stream().filter(a-> (a.toLowerCase())!=(a.toUpperCase())).collect(Collectors.toList());
        Collections.sort(actualItems);

        return actualItems;
    }


}
