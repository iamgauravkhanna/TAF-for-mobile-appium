package android.project03;

import base.BaseTest;
import logger.TestLogger;
import org.testng.annotations.Test;
import screens.android.project03.LoginScreen;
import screens.android.project03.ProductsScreen;

public class SwagLabsTest extends BaseTest {

    @Test(description = "Sanity test for Swag Labs")
    public void userShouldBeAbleToLogin(){

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.enterUsername("standard_user");
        loginScreen.enterPassword("secret_sauce");
        loginScreen.pressLoginBtn();

        ProductsScreen productsScreen = new ProductsScreen();
        String actualProductTitle = productsScreen.getTitle();
        TestLogger.INFO_EXTENT("Title is : " + actualProductTitle);
    }
}
