package android.project01;

import base.BaseTest;
import logger.TestLogger;
import org.testng.annotations.Test;
import screens.android.project01.StartScreen;
import screens.android.project01.ViewsScreen;

public class TestClassB extends BaseTest {

    @Test(description = "Test Case #1 Tap Example", enabled = false)
    public void tapSwitchOnOff(){

        StartScreen startScreen = new StartScreen();
        startScreen.clickOnView();
        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.goToSwitches();
        TestLogger.INFO("Switch Text : " + viewsScreen.getSwitchText());
    }
}
