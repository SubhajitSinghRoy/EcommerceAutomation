package com.AbstractComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int max = 1;
    int count = 0;

    @Override
    public boolean retry(ITestResult result) {

        if (max>count) {
         count++;
         System.out.println("value of count is \n" +count);
            return true;
        }
       else
        return false;
    }
}
