package base;

import driver.DriverManager;
import enums.MobilePlatform;
import factory.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import screenrecording.ScreenRecordingService;
import appium.AppiumServerUtils;

import java.util.Objects;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup() {
//        AppiumServerUtils.startAppiumServer();
    }

    @BeforeMethod
    public void setup() {

        String whichPlatform = System.getProperty("platform");

        if (Objects.isNull(DriverManager.getDriver())) {
            if (whichPlatform.equalsIgnoreCase(MobilePlatform.ANDROID.name())) {
                DriverFactory.initializeDriver(MobilePlatform.ANDROID, "emulator-5554", "myudid", 7777, "yes");
            } else if (whichPlatform.equalsIgnoreCase(MobilePlatform.IOS.name())) {
                DriverFactory.initializeDriver(MobilePlatform.IOS, "iPhone 13 Pro Max", "myudid", 4723, "yes");
            } else if (whichPlatform.equalsIgnoreCase(MobilePlatform.ANDROID_WEB.name()))
                DriverFactory.initializeDriver(MobilePlatform.ANDROID_WEB, "emulator-5554", "myudid", 8760, "yes");
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
