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
            doClear(element);
            element.sendKeys(value, Keys.ENTER);
        } catch (Exception e) {
        }
    }

    protected void doClear(MobileElement element) {
        element.clear();
    }
}
