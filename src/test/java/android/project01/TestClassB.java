package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.StartScreen;
import screens.android.project01.ViewsScreen;

public class TestClassB extends BaseTest {

    @Test(description = "Test Case #3", enabled = false)
    public void SanityTest(){

        StartScreen start = new StartScreen();
        start.clickOnView();
    }

    @Test(description = "Test Case #4 check box example", enabled = false)
    public void checkBoxExample(){
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewsScreen view = new ViewsScreen();
        view.clickOption();
    }
}
