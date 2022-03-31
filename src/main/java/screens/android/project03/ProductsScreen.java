package screens.android.project03;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import screens.BaseScreen;

public class ProductsScreen extends BaseScreen {

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private MobileElement productTitle;

    public String getTitle() {
        return getElementText(productTitle);
    }
}
