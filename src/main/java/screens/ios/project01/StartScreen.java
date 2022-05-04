package screens.ios.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.*;
import screens.BaseScreen;

public class StartScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeIcon[@name='Settings']")
    MobileElement settingIcon ;

    public void clickSettingIcon(){
        pressHomeButton();
        pause();
        singleTap(settingIcon);
    }

}
