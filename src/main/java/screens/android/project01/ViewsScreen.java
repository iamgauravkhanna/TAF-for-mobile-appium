package screens.android.project01;

import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class ViewsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Controls")
    private MobileElement controls;

    @AndroidFindBy(id = "io.appium.android.apis:id/monitored_switch")
    private MobileElement monitoredSwitch;

    public void clickOption() {
        longPress(controls,5);
    }

    public void goToSwitches() {
        scrollToElementAndClick("Switches");
    }

    public String getSwitchText() {
//        return getMobileElement("io.appium.android.apis:id/monitored_switch", MobileFindBy.ID).getText();
        return monitoredSwitch.getText();
    }
}