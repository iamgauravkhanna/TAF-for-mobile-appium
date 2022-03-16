package base;

import driver.DriverManager;
import enums.MobilePlatformName;
import factory.DriverFactory;
import org.openqa.selenium.Platform;
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

        if (whichPlatform.equalsIgnoreCase(MobilePlatformName.ANDROID.name())){
            if (Objects.isNull(DriverManager.getDriver())) {
                DriverFactory.initializeDriver(MobilePlatformName.ANDROID, "emulator-5554", "myudid", 7777, "yes");
            }
        }
        else if(whichPlatform.equalsIgnoreCase(MobilePlatformName.IOS.name())){
            if (Objects.isNull(DriverManager.getDriver())) {
                DriverFactory.initializeDriver(MobilePlatformName.IOS, "iPhone 13 Pro Max", "myudid", 4723, "yes");
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
