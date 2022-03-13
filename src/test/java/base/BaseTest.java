package base;

import driver.DriverManager;
import enums.MobilePlatformName;
import factory.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import screenrecording.ScreenRecordingService;
import utils.AppiumServerUtils;

import java.util.Objects;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup() {
        AppiumServerUtils.startAppiumServer();
    }

    @BeforeMethod
    public void setup() {

        String whichPlatform = System.getProperty("platform");

        if (whichPlatform.toUpperCase().equals("ANDROID")){
            if (Objects.isNull(DriverManager.getDriver())) {
                DriverFactory.initializeDriver(MobilePlatformName.ANDROID, "emulator-5554", "myudid", 7777, "yes");
            }
        }
        ScreenRecordingService.startRecording();
    }

    @AfterMethod
    protected void tearDown(ITestResult result) {
        ScreenRecordingService.stopRecording(result.getName());
        DriverFactory.quitDriver();
    }

    @AfterSuite(alwaysRun = true)
    protected void afterSuite() {
        AppiumServerUtils.stopAppiumServer();
    }

}
