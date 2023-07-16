package steps;

import pages.HomePage;
import support.Base;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ErrorValidationTests extends Base {


    @DataProvider
    public Object[][] getData(){

        HashMap<String,String> map = new HashMap<>();
        map.put("user","testingsubhajit220@gmail.com");
        map.put("pass","Aug@12345");

        HashMap<String,String> map1 = new HashMap<>();
        map1.put("user","agasow460@favilu.com");
        map1.put("pass","Aug@4312");

        return new Object[][]{{map},{map1}};

    }
    @Test(dataProvider = "getData")
    public void loginError(HashMap<String,String> input){
    HomePage homePage = loginPage.loginToApp(input.get("user"), input.get("pass"));
        Assert.assertTrue(loginPage.errorMessage().equalsIgnoreCase("Incorrect email or password."),
                "Error Message do not match" );

}}
