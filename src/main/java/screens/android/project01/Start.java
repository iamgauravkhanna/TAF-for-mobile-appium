package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import screens.BaseScreen;

public class Start extends BaseScreen {

    @AndroidFindBy(accessibility="Views")
    private static MobileElement view;

    public void performSanity() {

        Boolean isDisplayed;
        isDisplayed = view.isDisplayed();
        Assert.assertEquals(true,isDisplayed);
    }
}
