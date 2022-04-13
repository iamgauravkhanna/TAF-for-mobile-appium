package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.BaseScreen;

public class DarkThemeScreen extends BaseScreen {

    @AndroidFindBy(accessibility="Checkbox 2")
    private MobileElement checkBox;

    public void selectCheckBox() {
        click(checkBox);
    }

}
