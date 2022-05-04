package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.*;

public class TestClassC extends BaseTest {

    @Test(description = "Push Notification Test", enabled = true)
    public void TestMethodA() {

        StartScreen start = new StartScreen();
        start.clickOnApp();
        AppScreen appScreen = new AppScreen();
        appScreen.triggerNotification() ;
        appScreen.openNotificationsOnAndroid();
        appScreen.findCustomNotification();
    }
}
