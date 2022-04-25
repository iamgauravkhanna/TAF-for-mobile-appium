package screens.ios.project02;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import screens.BaseScreen;

public class LoginScreen extends BaseScreen {

    @iOSXCUITFindBy(id = "test-Username")
    private MobileElement username;

    @iOSXCUITFindBy (id = "test-Password")
    private MobileElement password;

    @iOSXCUITFindBy (id = "test-LOGIN")
    private MobileElement loginButton;

    public LoginScreen enterUserName(String user) {
        sendKeys(username, user);
        return this;
    }

    public LoginScreen enterPassword(String pass) {
        sendKeys(password, pass);
        return this;
    }

    public void pressLoginButton() {
        click(loginButton);
    }
}
