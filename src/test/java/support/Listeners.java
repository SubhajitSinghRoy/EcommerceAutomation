package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import steps.Base;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listeners extends Base implements ITestListener {

    ExtentTest extentTest;

    ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<>(); // thread safe

    ExtentReports extentReports= TestNGReport.extentReportSetup();
    @Override
    public void onTestStart(ITestResult result) {

        extentTest=extentReports.createTest(result.getMethod().getMethodName());
        threadLocal.set(extentTest); // each test objects would have an unique thread id
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        threadLocal.get().log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        // publish fail reason
       // extentTest.
                threadLocal.get().fail(result.getThrowable());// fetch the unique thread id for the test object
        // take screenshot
        String filePath=null;
        WebDriver driver =
                null;

        System.out.println("It should take screenshot");

        try {
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
            System.out.println("The method name is "+result.getMethod().getMethodName());
            System.out.println("The class name is " +result.getTestClass().getRealClass());
            filePath= getScreenshot(result.getMethod().getMethodName(),driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // attach screenshot to report

        threadLocal.get().addScreenCaptureFromPath(filePath,
                result.getMethod().getMethodName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();

    }
}
