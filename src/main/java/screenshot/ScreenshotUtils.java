package screenshot;

import constants.TestConstants;
import driver.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.JavaUtil;

import java.io.File;
import java.io.IOException;

import static constants.TestConstants.SCREENSHOTS_PATH;

public final class ScreenshotUtils {

    private ScreenshotUtils() {}

    public static void captureScreenshotAsFile() {
        File source = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
        File destination = new File(SCREENSHOTS_PATH + File.separator + JavaUtil.getCurrentTimeStamp() + ".png");
        try {
            FileUtils.copyFile(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String captureScreenshotAsBase64() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
    }
}
