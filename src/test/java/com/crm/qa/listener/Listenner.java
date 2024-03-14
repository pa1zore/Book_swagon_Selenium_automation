package com.crm.qa.listener;

import com.aventstack.extentreports.ExtentTest;
import com.crm.qa.base.TestBase;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenner extends TestBase implements ITestListener  {

    public void onTestStart(ITestResult result) {
        System.out.println(".....onTestStart...... "+ result.getName());
       extent.attachReporter(spark);

    }
    public void onTestSuccess(ITestResult result) {
        System.out.println(".....onTestSuccess...... "+ result.getName());
        ExtentTest extentTest= extent.createTest(result.getName());
        extentTest.pass("Test successfully executed");
        extent.flush();
    }


    public void onTestFailure(ITestResult result) {
        System.out.println(".....onTestFailure...... "+ result.getName());
        ExtentTest extentTest= extent.createTest(result.getName());
        extentTest.fail("Test failed ");
        extent.flush();
    }



    public void onTestSkipped(ITestResult result) {
        System.out.println(".....onTestSkipped...... "+ result.getName());
        ExtentTest extentTest= extent.createTest(result.getName());
        extentTest.skip("Test skipped");
        extent.flush();
    }
}
