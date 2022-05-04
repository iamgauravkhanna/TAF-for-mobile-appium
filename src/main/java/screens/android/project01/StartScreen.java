package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import screens.BaseScreen;
import screenshot.ScreenshotUtils;

public class StartScreen extends BaseScreen {

    @AndroidFindBy(accessibility="Views")
    private static MobileElement view;

    @AndroidFindBy(accessibility="App")
    private static MobileElement app;

    public void clickOnView(){
        verifyOptions();
        click(view);
    }

    public void verifyOptions() {
        ScreenshotUtils.captureScreenshotAsFile();
        isElementDisplayed(view);
    }

    public void clickOnApp(){
        click(app);
    }
}
