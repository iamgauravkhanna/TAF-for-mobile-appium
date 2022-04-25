package screens;

import constants.TestConstants;
import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import logger.TestLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screenshot.ScreenshotService;

public class BaseScreen {

    protected BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
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
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(mobileElement));
    }

    public MobileElement getMobileElement(String mobileElement, MobileFindBy mobileFindBy) {
        switch (mobileFindBy) {
            case XPATH:
                return DriverManager.getDriver().findElementByXPath(mobileElement);
            case CSS:
                return DriverManager.getDriver().findElementByCssSelector(mobileElement);
            case ID:
                return DriverManager.getDriver().findElementById(mobileElement);
            case NAME:
                return DriverManager.getDriver().findElementByName(mobileElement);
            case ACCESSIBILITY_ID:
                return DriverManager.getDriver().findElementByAccessibilityId(mobileElement);
            case CLASS:
                return DriverManager.getDriver().findElementByClassName(mobileElement);
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
        TestLogger.INFO_DETAILED_EXTENT("Click on Element : " + element.getAttribute("name"));
        ScreenshotService.captureScreenshotAsFile();
        element.click();
    }

    protected boolean isElementDisplayed(MobileElement element) {
        TestLogger.INFO_DETAILED_EXTENT("Verify if element " + element.getAttribute("name") + " is displayed on UI");
        return element.isDisplayed();
    }

    protected String getElementAttribute(MobileElement element, String attributeName) {
        return element.getAttribute(attributeName);
    }

    protected void getServerStatus() {
        DriverManager.getDriver().getStatus();
    }

    protected boolean isElementSelected(MobileElement element) {
        return element.isSelected();
    }

    protected boolean isElementEnabled(MobileElement element) {
        return element.isEnabled();
    }

    protected void doubleClickOnElement(WebElement element) {
        new Actions(DriverManager.getDriver())
                .moveToElement(element)
                .doubleClick()
                .perform();
        TestLogger.INFO_EXTENT("Double click on element : " + element);
    }

    protected void performSingleTap(MobileElement element) {
        new TouchActions(DriverManager.getDriver())
                .singleTap(element)
                .perform();
        TestLogger.INFO_EXTENT("Single tap on element : " + element);
    }

    protected void performDoubleTap(MobileElement element) {
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

    public void scrollToElementAndClick(String value){
        String selector = "new UiScrollable(new UiSelector()).scrollIntoView(" + "new UiSelector().text(\"" + value + "\"));";
       getMobileElement(MobileFindBy.ANDROID_UI_AUTOMATOR,selector).click();
    }

}
