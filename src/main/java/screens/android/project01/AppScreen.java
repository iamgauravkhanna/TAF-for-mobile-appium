package screens.android.project01;

import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logger.TestLogger;
import screens.BaseScreen;

import java.util.List;

public class AppScreen extends BaseScreen {

    @AndroidFindBy(id = "Alert Dialogs")
    private MobileElement alertDialog;

    @AndroidFindBy(id = "OK Cancel dialog with a message")
    private MobileElement option1;

    public void clickOkOnAlert() {
        click(alertDialog);
        click(option1);
        String result = getMobileElement("android:id/alertTitle", MobileFindBy.ID).getText();
        TestLogger.INFO("Alert Text = " + result);
        getMobileElement("android:id/button1", MobileFindBy.ID).click();
    }

    public void triggerNotification() {
        getMobileElement("Notification", MobileFindBy.ACCESSIBILITY_ID).click();
        getMobileElement("IncomingMessage", MobileFindBy.ACCESSIBILITY_ID).click();
        getMobileElement("Show Interstitial Notification", MobileFindBy.ACCESSIBILITY_ID).click();
        pause();
    }

    public void findCustomNotification() {
        List<MobileElement> allnotifications = getMobileElements("android:id/title", MobileFindBy.ID);
        TestLogger.INFO("no of notifications " + allnotifications.size());
        for (MobileElement mobileElement : allnotifications) {
            TestLogger.INFO(mobileElement.getText());
            if (mobileElement.getText().contains("Dianne")) {
                TestLogger.INFO("Notification found");
                break;
            }
        }
    }
}
