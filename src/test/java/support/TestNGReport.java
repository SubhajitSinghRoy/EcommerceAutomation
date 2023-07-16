package support;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestNGReport {

    public static ExtentReports extentReportSetup() {
        String path="src/main/resources/reports";
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(path);
        extentSparkReporter.config().setReportName("Web Automation Results");
        extentSparkReporter.config().setDocumentTitle("Validation Report");

        ExtentReports extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);
        extentReports.setSystemInfo("QA Resource","Subhajit Singh Roy");

        return extentReports;


    }
}
