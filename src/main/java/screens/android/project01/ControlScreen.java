package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.BaseScreen;

public class ControlScreen extends BaseScreen {

    @AndroidFindBy(accessibility="2. Dark Theme")
    private MobileElement theme;

    public void selectTheme() {
        tapAtLocation(theme.getCenter().getX(),theme.getCenter().getY());
    }

}
