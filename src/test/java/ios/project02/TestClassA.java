package ios.project02;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.ios.project02.LoginScreen;


public class TestClassA extends BaseTest {

    @Test(description = "Sanity Test",enabled = false)
    public void TestMethodA(){
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterUserName("standard_user");
        loginScreen.enterPassword("secret_sauce");
        loginScreen.pressLoginButton();
    }
}
