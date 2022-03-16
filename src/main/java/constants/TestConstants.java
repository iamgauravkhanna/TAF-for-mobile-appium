package constants;

import enums.ConfigProperties;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import property.PropertyUtils;
import utils.JavaUtil;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestConstants {

    public static final String PROJECT_PATH = System.getProperty("user.dir");

    public static final String appiumServerHost = "127.0.0.1";

    private static final int appiumServerPort = 4723;

    private static final String appiumJsPath = System.getenv("APPIUM_HOME") + File.separator + "main.js";

    private static final String androidApkPath = PROJECT_PATH + File.separator + "src/test/resources" + File.separator + "app" + File.separator + "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";

    private static final String chromedriverExecutablesPath = PROJECT_PATH + File.separator + "src/test/resources" + File.separator + "executables" + File.separator + "chromedriver.exe";

    public static final String CONFIG_PROPERTIES_PATH = PROJECT_PATH + File.separator + "src/test/resources" + File.separator + "config" + File.separator + System.getProperty("platform") + File.separator + System.getProperty("project") + File.separator + "config.properties";

    public static final String CONFIG_JSON_PATH = PROJECT_PATH + File.separator + "src/test/resources" + File.separator + "config" + File.separator + System.getProperty("platform") + File.separator + System.getProperty("project") + File.separator +  "config.json";

    private static final long explicitWait = 15;

    private static final String screenshotPath = PROJECT_PATH + File.separator + "screenshots";

    private static final String testDataFilePath = PROJECT_PATH + File.separator + "src/test/resources" + File.separator + "data" + File.separator + "testdata.xlsx";

    private static final String nodeJsPath = System.getenv("NODE_HOME") + File.separator + "node.exe";

    private static final String extentReportPath = PROJECT_PATH + File.separator + "extent-test-report";

    public static String getExtentReportPath() {
        if (PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDE_REPORTS).equalsIgnoreCase("yes")) {
            return extentReportPath + File.separator + "index.html";
        } else {
            return extentReportPath + File.separator + JavaUtil.getCurrentDateTime() + File.separator + "index.html";
        }
    }

    private static final String appiumServerLogsPath = PROJECT_PATH + File.separator + "server-logs";

    public static String getAppiumServerLogsPath() {
        if (PropertyUtils.getPropertyValue(ConfigProperties.OVERRIDE_SERVER_LOG).equalsIgnoreCase("yes")) {
            return appiumServerLogsPath + File.separator + "server.log";
        } else {
            return appiumServerLogsPath + File.separator + JavaUtil.getCurrentDateTime() + File.separator + "server.log";
        }
    }

    private static final String screenRecordingsPath = PROJECT_PATH + File.separator + "screen-recordings";

    public static String getScreenRecordingsPath() {
        File screenRecordingsDir = new File(screenRecordingsPath);
        if (!screenRecordingsDir.exists()) {
            screenRecordingsDir.mkdir();
        }
        return screenRecordingsPath;
    }

    public static final String INVALID_LOGIN_ERROR_MESSAGE = "Username and password do not match any user in this service.";

    public static final String PRODUCT_PAGE_TITLE = "PRODUCTS";

    public static final String SEARCH_RESULTS_PAGE_TITLE = "Appium - Google Search";

    public static final String LOG4J_PATH = System.getProperty("user.dir") + File.separator + "log4j.properties";
}