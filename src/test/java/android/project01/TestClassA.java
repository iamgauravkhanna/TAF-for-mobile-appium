package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.ControlScreen;
import screens.android.project01.DarkThemeScreen;
import screens.android.project01.StartScreen;
import screens.android.project01.ViewsScreen;

public class TestClassA extends BaseTest {

    @Test(description = "Test Case #1 Verify View Screen", enabled = false)
    public void SanityTestA(){

        StartScreen start = new StartScreen();
        start.clickOnView();
    }

    @Test(description = "Test Case #2 check box example", enabled = true)
    public void SanityTestB(){
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewsScreen view = new ViewsScreen();
        view.clickOption();
        ControlScreen controlScreen = new ControlScreen();
        controlScreen.selectTheme();
        DarkThemeScreen darkThemeScreen = new DarkThemeScreen();
        darkThemeScreen.selectCheckBox();
    }
}
