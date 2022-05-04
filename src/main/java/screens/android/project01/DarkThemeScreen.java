package screens.android.project01;

import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import logger.TestLogger;
import org.testng.annotations.Test;
import screens.BaseScreen;

import java.util.List;

public class DarkThemeScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Checkbox 2")
    private MobileElement checkBox;

    @AndroidFindBy(id = "android:id/text1")
    private MobileElement dropDown;

    public void selectCheckBox() {
        click(checkBox);
    }

    public void printDropDownValues() {
        hideKeyboard();
        dropDown.click();
        List<MobileElement> list = getMobileElements("android:id/text1", MobileFindBy.ID);
        for (int i = 0; i < list.size(); i++)
            TestLogger.INFO(getElementText(list.get(i)));
    }
}
