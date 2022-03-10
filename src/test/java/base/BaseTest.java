package base;

import driver.DriverManager;
import enums.MobilePlatformName;
import factory.DriverFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utils.AppiumServerUtils;
import utils.screenrecording.ScreenRecordingService;

import java.util.Objects;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup(){
        System.out.println("Steps to be performed before starting suite");
        AppiumServerUtils.startAppiumServer();
    }

    @BeforeMethod
    public void setup(String platformName, String udid, String deviceName, @Optional("androidOnly") String systemPort,
                      @Optional("androidOnly") String chromeDriverPort, @Optional("androidOnly") String emulator,
                      @Optional("iOSOnly") String wdaLocalPort, @Optional("iOSOnly") String webkitDebugProxyPort){
        if (Objects.isNull(DriverManager.getDriver())) {
            DriverFactory.initializeDriver(MobilePlatformName.ANDROID, deviceName, udid, Integer.parseInt(systemPort), emulator);
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
