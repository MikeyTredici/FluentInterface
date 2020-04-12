package org.example.listeners;

import com.aventstack.extentreports.Status;
import org.example.utilities.PageBase;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        System.out.println("on test start");
        PageBase.logger.log(Status.INFO, tr.getMethod().getMethodName() + " test started");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        System.out.println("on test success");
        PageBase.logger.log(Status.PASS, tr.getMethod().getMethodName() + " test passed");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        System.out.println("on test failure");
        PageBase.logger.log(Status.FAIL, tr.getMethod().getMethodName() + " test failed");
        PageBase.logger.log(Status.FAIL, tr.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        System.out.println("on test skip");
        PageBase.logger.log(Status.SKIP, tr.getMethod().getMethodName() + " test skipped");
    }
}
