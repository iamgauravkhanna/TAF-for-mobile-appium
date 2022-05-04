package screens.android.project01;

import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logger.TestLogger;
import screens.BaseScreen;

public class AppScreen extends BaseScreen {

    @AndroidFindBy(id="Alert Dialogs")
    private MobileElement alertDialog;

    @AndroidFindBy(id="OK Cancel dialog with a message")
    private MobileElement option1;

    public void clickOkOnAlert(){
        click(alertDialog);
        click(option1);
        String result = getMobileElement("android:id/alertTitle", MobileFindBy.ID).getText();
        TestLogger.INFO("Alert Text = " + result);
        getMobileElement("android:id/button1",MobileFindBy.ID).click();
    }
}
