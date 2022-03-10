package screens.android.project01;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class Start {

    @FindBy(id="Views")
    private static MobileElement view;

    public void performSanity() {

        Boolean isDisplayed;
        isDisplayed = view.isDisplayed();

        System.out.println("Elements Visible on UI ? - " + isDisplayed);
    }
}
