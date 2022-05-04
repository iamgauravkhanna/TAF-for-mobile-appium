package ios.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.ios.project01.GeneralScreen;
import screens.ios.project01.StartScreen;


public class TestClassA extends BaseTest {

    @Test(description = "Find Element Example",enabled = true)
    public void TestMethodA(){
        StartScreen startScreen = new StartScreen();
        startScreen.clickSettingIcon();
        GeneralScreen generalScreen = new GeneralScreen();
        generalScreen.clickGeneral();
        generalScreen.clickAbout();
    }
}
