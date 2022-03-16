package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class View extends BaseScreen {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Controls\"]")
    private MobileElement controls;

    public void clickOption() {
        click(controls);
    }

}
