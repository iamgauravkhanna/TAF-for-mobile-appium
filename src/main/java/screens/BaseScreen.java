package screens;

import com.google.common.collect.ImmutableMap;
import constants.TestConstants;
import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import logger.TestLogger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenshot.ScreenshotService;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import static constants.TestConstants.EXPLICIT_WAIT;

public class BaseScreen {

    protected WebDriverWait wait;

    protected BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
        wait = new WebDriverWait(DriverManager.getDriver(), 10);
    }

    public void getUrl(String url) {
        DriverManager.getDriver().get(url);
    }

    protected void sendKeys(MobileElement mobileElement, String text) {
        waitForVisibility(mobileElement);
        clear(mobileElement);
        TestLogger.INFO_EXTENT("Filling data in <b>" + mobileElement.getAttribute("name") + "</b>");
        mobileElement.sendKeys(text);
    }

    public void waitForVisibility(MobileElement mobileElement) {
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement getMobileElement(String selector, MobileFindBy mobileFindBy) {
        pause();
        switch (mobileFindBy) {
            case XPATH:
                return DriverManager.getDriver().findElementByXPath(selector);
            case CSS:
                return DriverManager.getDriver().findElementByCssSelector(selector);
            case ID:
                return DriverManager.getDriver().findElementById(selector);
            case NAME:
                return DriverManager.getDriver().findElementByName(selector);
            case ACCESSIBILITY_ID:
                return DriverManager.getDriver().findElementByAccessibilityId(selector);
            case CLASS:
                return DriverManager.getDriver().findElementByClassName(selector);
        }
        return null;
    }

    public List<MobileElement> getMobileElements(String selector, MobileFindBy mobileFindBy) {
        switch (mobileFindBy) {
            case XPATH:
                return DriverManager.getDriver().findElementsByXPath(selector);
            case CSS:
                return DriverManager.getDriver().findElementsByCssSelector(selector);
            case ID:
                return DriverManager.getDriver().findElementsById(selector);
            case NAME:
                return DriverManager.getDriver().findElementsByName(selector);
            case ACCESSIBILITY_ID:
                return DriverManager.getDriver().findElementsByAccessibilityId(selector);
            case CLASS:
                return DriverManager.getDriver().findElementsByClassName(selector);
        }
        return null;
    }

    private MobileElement getMobileElement(MobileFindBy mobileFindBy, String selector) {
        switch (mobileFindBy) {
            case ANDROID_UI_AUTOMATOR:
                return (MobileElement) DriverManager.getDriver().findElement(MobileBy.AndroidUIAutomator(selector));
            case IOS_UI_AUTOMATOR:
                return (MobileElement) DriverManager.getDriver().findElement(MobileBy.iOSClassChain(selector));
        }
        return null;
    }

    protected void enterValueAndPressEnter(MobileElement element, String value, String elementName) {
        try {
            clear(element);
            element.sendKeys(value, Keys.ENTER);
        } catch (Exception e) {
        }
    }

    protected void clear(MobileElement element) {
        TestLogger.INFO_EXTENT("Clearing Text from Input");
        element.clear();
    }

    protected void click(MobileElement element) {
        waitForVisibility(element);
        TestLogger.INFO_DETAILED_EXTENT("Click on Element : " + element.getAttribute("name"));
        ScreenshotService.captureScreenshotAsFile();
        element.click();
    }

    protected boolean isElementDisplayed(MobileElement element) {
        TestLogger.INFO_DETAILED_EXTENT("Verify if element " + element.getAttribute("name") + " is displayed on UI");
        return element.isDisplayed();
    }

    protected boolean isElementSelected(MobileElement element) {
        TestLogger.INFO_DETAILED_EXTENT("Verify if element " + element.getAttribute("name") + " is selected on UI");
        return element.isSelected();
    }

    protected boolean isElementEnabled(MobileElement element) {
        TestLogger.INFO_DETAILED_EXTENT("Verify if element " + element.getAttribute("name") + " is enabled on UI");
        return element.isEnabled();
    }


    protected String getElementAttribute(MobileElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    protected void getServerStatus() {
        DriverManager.getDriver().getStatus();
    }

    protected void doubleClickOnElement(WebElement element) {
        new Actions(DriverManager.getDriver())
                .moveToElement(element)
                .doubleClick()
                .perform();
        TestLogger.INFO_EXTENT("Double click on element : " + element);
    }

    protected void singleTap(MobileElement element) {
        performMultipleTap(element, 1);
        TestLogger.INFO_EXTENT("Single tap on element : " + element);
    }

    protected void doubleTap(MobileElement element) {
        performMultipleTap(element, 2);
        TestLogger.INFO_EXTENT("Double tap on element : " + element);
    }

    protected void performMultipleTap(MobileElement element, int tapCount) {
        new TouchAction(DriverManager.getDriver())
                .tap(TapOptions.tapOptions()
                        .withElement(ElementOption.element(element))
                        .withTapsCount(tapCount))
                .perform();

    }

    public String getElementText(MobileElement mobileElement) {

        waitForVisibility(mobileElement);

        String whichPlatform = System.getProperty("platform");
        if (whichPlatform.contains("android")) {
            return mobileElement.getAttribute(TestConstants.TEXT);
        } else if (whichPlatform.contains("ios")) {
            return mobileElement.getAttribute(TestConstants.LABEL);
        }
        return null;
    }

    public void scrollToElementAndClick(String value) {
        pause(2);
        String selector = "new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + value + "\"));";
        getMobileElement(MobileFindBy.ANDROID_UI_AUTOMATOR, selector).click();
    }

    public void longPress(MobileElement mobileElement, int duration) {
        new TouchAction<>(DriverManager.getDriver())
                .longPress(LongPressOptions
                        .longPressOptions()
                        .withElement(ElementOption.element(mobileElement))
                        .withDuration(Duration.ofSeconds(duration)))
                .release()
                .perform();
        TestLogger.INFO("Long Press on element : " + mobileElement);
    }

    public void tapAtLocation(int xOffset, int yOffset) {
        new TouchAction<>(DriverManager.getDriver())
                .tap(PointOption
                        .point(xOffset, yOffset))
                .perform();
        TestLogger.INFO_EXTENT("tapAtLocation at xOffSet : " + xOffset + " && yOffSet : " + yOffset);
    }

    public void printMobileDeviceTime() {
        TestLogger.INFO("Time : " + String.valueOf(DriverManager.getDriver().executeScript("mobile: getDeviceTime")));
    }

    public void printPermissions() {
        TestLogger.INFO("List of Permissions : " + String.valueOf(DriverManager.getDriver().executeScript("mobile: getPermissions")));
    }

    public void pause() {
        try {
            TestLogger.INFO("Pausing for " + 5 + " seconds...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pause(int seconds) {
        try {
            TestLogger.INFO("Pausing for " + seconds + " seconds...");
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printNotifications() {

        Map<String, Object> notificationList = (Map<String, Object>) DriverManager.getDriver().executeScript("mobile: getNotifications");

        List<Map<String, Object>> notifications = (List<Map<String, Object>>) notificationList.get("statusBarNotifications");

        for (Map<String, Object> notification : notifications) {
            Map<String, String> innerNotification = (Map<String, String>) notification.get("notification");
            if (innerNotification.get("bigTitle") != null) {
                System.out.println("Big Title : " + innerNotification.get("bigTitle"));
            } else {
                System.out.println("Title : " + innerNotification.get("title"));
            }
            if (innerNotification.get("bigText") != null) {
                System.out.println("Big Text" + innerNotification.get("bigText"));
            } else {
                System.out.println("Text :" + innerNotification.get("text"));
            }
        }
    }

    public void swipe() {
        Dimension dimension = DriverManager.getDriver().manage().window().getSize();
        PointOption pointOptionStart = PointOption.point(dimension.width / 2, dimension.height / 2);
        PointOption pointOptionEnd = PointOption.point((int) (dimension.width * 0.1), (int) (dimension.height * 0.1));
        TouchAction touchAction = new TouchAction(DriverManager.getDriver());

        touchAction
                .press(pointOptionStart)
                .waitAction(WaitOptions
                        .waitOptions(Duration.ofSeconds(4)))
                .moveTo(pointOptionEnd)
                .release()
                .perform();
    }

    /**
     * Print Current Activity Name
     */
    public void getCurrentActivity() {
        String activityName = ((AndroidDriver) DriverManager.getDriver()).currentActivity();
        TestLogger.INFO("Current Activity : " + activityName);
    }

    public void openNotificationsOnAndroid() {
        TestLogger.INFO("Open Notifications....");
        ((AndroidDriver) DriverManager.getDriver()).openNotifications();
    }

    public void pressHomeButton() {
        TestLogger.INFO("Pressing Home Button");
        ImmutableMap pressHome = ImmutableMap.of("name", "home");
        DriverManager.getDriver().executeScript("mobile: pressButton", pressHome);
    }

    public void hideKeyboard() {
        DriverManager.getDriver().hideKeyboard();
    }

    public void rotateScreenToLANDSCAPE() {
        TestLogger.INFO("Switch ScreenOrientation to LANDSCAPE");
        DriverManager.getDriver().rotate(ScreenOrientation.LANDSCAPE);
    }

    public void rotateScreenToPORTRAIT() {
        TestLogger.INFO("Switch ScreenOrientation to PORTRAIT");
        DriverManager.getDriver().rotate(ScreenOrientation.PORTRAIT);
    }

}