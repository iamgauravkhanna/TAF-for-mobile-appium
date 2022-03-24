package screens;

import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import logger.MyLogger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    protected BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }

    private MobileElement getMobileElement(String mobileElement, MobileFindBy mobileFindBy) {
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

    protected void enterValueAndPressEnter(MobileElement element, String value, String elementName) {
        try {
            clear(element);
            element.sendKeys(value, Keys.ENTER);
        } catch (Exception e) {
        }
    }

    protected void clear(MobileElement element) {
        element.clear();
    }

    protected void click(MobileElement element){
        element.click();
    }

    protected boolean isElementDisplayed(MobileElement element) {
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
     MyLogger.infoExtentStep("Double click on element : " + element);
    }

    protected void performSingleTap(WebElement element) {
        new TouchActions(DriverManager.getDriver())
                .singleTap(element)
                .perform();
        MyLogger.infoExtentStep("Single tap on element : " + element);
    }

    protected void performDoubleTap(WebElement element) {
        new TouchActions(DriverManager.getDriver())
                .doubleTap(element)
                .perform();
        MyLogger.infoExtentStep("Double tap on element : " + element);
    }

}
