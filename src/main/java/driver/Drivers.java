package driver;

import constants.TestConstants;
import customExceptions.DriverInitializationException;
import enums.ConfigJson;
import enums.MobileBrowser;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static json.JsonUtils.getConfig;

import java.net.URL;

public class Drivers {
    private Drivers() {
    }

    public static AppiumDriver<MobileElement> createAndroidDriverForNativeApp(String device_name, String udid, int port, String emulator) {
        try {
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2); // Specific to Android
            //capability.setCapability(MobileCapabilityType.UDID, udid); // To uniquely identify device
            //capability.setCapability(MobileCapabilityType.APP, FrameworkConstants.getAndroidApkPath()); // define apk path
            capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getConfig(ConfigJson.APP_PACKAGE));
            capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getConfig(ConfigJson.APP_ACTIVITY));
            //capability.setCapability(AndroidMobileCapabilityType.SYSTEM_PORT, 7878); // To set different port for each thread - This port is used to communicate with UiAutomator2
            capability.setCapability("noReset", "true"); // this should be depenedent on property
            if (emulator.equalsIgnoreCase("yes")) {
                //capability.setCapability(AndroidMobileCapabilityType.AVD, device_name);
                capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, Integer.parseInt(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT)));
            }
            return new AndroidDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }

    public static AppiumDriver<MobileElement> createAndroidDriverForWeb(String device_name, String udid, int port, String emulator) {
        try {
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.ANDROID);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
            //capability.setCapability(MobileCapabilityType.UDID, udid);
//            capability.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getConfig(ConfigJson.APP_PACKAGE));
//            capability.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getConfig(ConfigJson.APP_ACTIVITY));
            capability.setCapability(CapabilityType.BROWSER_NAME, MobileBrowser.CHROME);
            capability.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_PORT, port); // For Web view/Chrome browser to launch the browser on different port
            capability.setCapability("noReset", "true"); // this should be depenedent on property
            if (emulator.equalsIgnoreCase("yes")) {
                //capability.setCapability(AndroidMobileCapabilityType.AVD, device_name);
                capability.setCapability(AndroidMobileCapabilityType.AVD_LAUNCH_TIMEOUT, Integer.parseInt(getConfig(ConfigJson.AVD_LAUNCH_TIMEOUT)));
            }
            return new AndroidDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }

    public static AppiumDriver<MobileElement> createIOSDriverForNativeApp(String device_name, String udid, int port) {
        try {

//            File classpathRoot = new File(System.getProperty("user.dir"));
//            File appDir = new File(classpathRoot, "/build/");
//            File app = new File(appDir, "WordPress.app");
//            capability.setCapability("app", app.getAbsolutePath());

            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capability.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15.4");
            capability.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getConfig(ConfigJson.BUNDLE_ID));
            capability.setCapability(MobileCapabilityType.NO_RESET, getConfig(TestConstants.RESET_APP));
            //capability.setCapability(MobileCapabilityType.APP, TestConstants.iosAppPath + "SwagLabsMobileApp.app");
            //capability.setCapability(MobileCapabilityType.UDID, udid);
            //capability.setCapability(IOSMobileCapabilityType.WDA_LOCAL_PORT, port); // To set different port for each thread - This port is used to communicate with WebDriverAgent driver
            return new IOSDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize IOSDriverForNativeApp. Please check the desired capabilities", e);
        }
    }

    public static AppiumDriver<MobileElement> createIOSDriverForWeb(String device_name, String udid, int port) {
        try {
            DesiredCapabilities capability = new DesiredCapabilities();
            capability.setCapability(CapabilityType.PLATFORM_NAME, Platform.IOS);
            capability.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
            capability.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
            capability.setCapability(MobileCapabilityType.UDID, udid);
            capability.setCapability(IOSMobileCapabilityType.BUNDLE_ID, getConfig(ConfigJson.BUNDLE_ID));
            capability.setCapability("noReset", "true");
            capability.setCapability(CapabilityType.BROWSER_NAME, MobileBrowser.SAFARI);
            capability.setCapability("webkitDebugProxyPort", port); // For web view/Safari browser testing on real device

            return new IOSDriver<>(new URL(getConfig(ConfigJson.APPIUM_URL)), capability);
        } catch (Exception e) {
            throw new DriverInitializationException("Failed to initialize driver. Please check the desired capabilities", e);
        }
    }
}
