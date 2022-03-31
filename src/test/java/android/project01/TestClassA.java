package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.StartScreen;
import screens.android.project01.ViewScreen;


public class TestClassA extends BaseTest {

    @Test(description = "Test Case #1", enabled = true)
    public void SanityTest(){

        StartScreen start = new StartScreen();
        start.clickOnView();
    }

    @Test(description = "check box example", enabled = true)
    public void checkBoxExample(){
        StartScreen start = new StartScreen();
        start.clickOnView();
        ViewScreen view = new ViewScreen();
        view.clickOption();
    }
}
