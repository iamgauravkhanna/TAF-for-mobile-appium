package utils;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class BaseScreen {

    protected BaseScreen() {
        PageFactory.initElements(new AppiumFieldDecorator(DriverManager.getDriver()), this);
    }
}
