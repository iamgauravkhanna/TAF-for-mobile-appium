package android.project01;

import base.BaseTest;
import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import logger.TestLogger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import screens.android.project01.*;

public class TestClassB extends BaseTest {

    @Test(description = "Test Case #1 Tap Example", enabled = false)
    public void TestMethodA() {

        StartScreen startScreen = new StartScreen();
        startScreen.clickOnView();
        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.goToSwitches();
        TestLogger.INFO("Switch Text : " + viewsScreen.getSwitchText());
    }

    @Test(description = "Seek Bar Example", enabled = false)
    public void TestMethodB() {

        StartScreen startScreen = new StartScreen();
        startScreen.clickOnView();

        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.scrollToElementAndClick("Seek Bar");
        viewsScreen.moveSeekBar();
    }

    @Test(description = "Drag Drop Example", enabled = false)
    public void TestMethodC() {

        StartScreen startScreen = new StartScreen();
        startScreen.clickOnView();

        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.dragDropCase();
    }

    @Test(description = "Drop Down List Example", enabled = false)
    public void TestMethodD() {

        StartScreen startScreen = new StartScreen();
        startScreen.clickOnView();

        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.clickOption();

        ControlScreen controlScreen = new ControlScreen();
        controlScreen.selectTheme();

        DarkThemeScreen darkThemeScreen = new DarkThemeScreen();
        darkThemeScreen.printDropDownValues();
    }

    @Test(description = "Alert Example", enabled = true)
    public void TestMethodE() {
        StartScreen startScreen = new StartScreen();
        startScreen.clickOnApp();
        AppScreen appScreen = new AppScreen();
        appScreen.clickOkOnAlert();
    }
}
