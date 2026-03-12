package org.naukriAutomation.Listener;

import org.naukriAutomation.webdrivermanager.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class TestListener implements ITestListener {

//    private final WebDriver driver = DriverFactory.getDriver();
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        try {
//            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            FileHandler.copy(source, new File("target/failedTestShot.jpeg"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver(); // fresh reference
        if (driver != null) {
            try {
                File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                FileHandler.copy(source, new File("target/failedTestShot.jpeg"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}