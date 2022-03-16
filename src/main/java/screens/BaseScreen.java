package screens;

import driver.DriverManager;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    protected BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
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

    protected boolean isElementSelected(MobileElement element) {
        return element.isSelected();
    }

    protected boolean isElementEnabled(MobileElement element) {
        return element.isEnabled();
    }
}
