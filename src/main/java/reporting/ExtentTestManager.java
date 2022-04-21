package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import logger.TestLogger;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();

    static ExtentReports extent = ExtentManager.getInstance();

    public static synchronized ExtentTest getTest() {
        return (ExtentTest) extentTestMap.get((int) (long) (Thread.currentThread().getId()));
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName, String description) {

        TestLogger.INFO(testName + " : " + description);
        ExtentTest extentTest = extent.createTest(testName, description);
        extentTestMap.put((int) (long) (Thread.currentThread().getId()), extentTest);
        return extentTest;
    }
}
