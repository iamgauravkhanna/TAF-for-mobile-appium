package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.ControlScreen;
import screens.android.project01.DarkThemeScreen;
import screens.android.project01.StartScreen;
import screens.android.project01.ViewsScreen;

public class TestClassA extends BaseTest {

    @Test(description = "Test Case #1 Verify View Screen", enabled = false)
    public void sanityTest() {

        StartScreen start = new StartScreen();
        start.clickOnView();
    }

    @Test(description = "Test Case #2 check box example", enabled = false)
    public void checkBoxExample() {
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewsScreen view = new ViewsScreen();
        view.clickOption();
        ControlScreen controlScreen = new ControlScreen();
        controlScreen.selectTheme();
        DarkThemeScreen darkThemeScreen = new DarkThemeScreen();
        darkThemeScreen.selectCheckBox();
    }

    @Test(description = "Test Case for execute Scripts", enabled = false)
    public void TestMethodC() {
        StartScreen start = new StartScreen();
        start.clickOnView();
//        start.printMobileDeviceTime();
//        start.pause();
//        start.printPermissions();
//        start.pause();
        // start.printNotifications();
        start.pause();
        start.swipe();
        start.pause();
        start.getCurrentActivity();
        start.openNotificationsOnAndroid();
    }

    @Test(description = "Test Case for scroll", enabled = false)
    public void TestMethodD() {
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.goTab();
    }

    @Test(description = "Select Date and Time Example", enabled = false)
    public void TestMethodE() {
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewsScreen viewsScreen = new ViewsScreen();
        viewsScreen.selectOption("Date Widgets");
        viewsScreen.selectOption("1. Dialog");
        viewsScreen.selectOption("change the date");
        viewsScreen.selectDay("20");
        viewsScreen.pause(3);
    }
}
