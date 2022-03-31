package screens.android.project02;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class GoogleHomePage extends BaseScreen {

    public void openHomePage(String url) {
        getUrl(url);
    }
}