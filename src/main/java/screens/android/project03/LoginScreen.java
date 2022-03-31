package screens.android.project03;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import screens.BaseScreen;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "test-Username")
    private MobileElement txtFldUsername;

    @AndroidFindBy(accessibility = "test-Password")
    private MobileElement txtFldPassword;

    @AndroidFindBy(accessibility = "test-LOGIN")
    private MobileElement btnLogin;

    public void enterUsername(String userName) {
        sendKeys(txtFldUsername,userName);
    }

    public void enterPassword(String password) {
        sendKeys(txtFldPassword,password);
    }

    public void pressLoginBtn() {
        click(btnLogin);
    }

}
