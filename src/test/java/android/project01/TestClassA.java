package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.Start;
import screens.android.project01.View;


public class TestClassA extends BaseTest {

    @Test(description = "Test Case #1", enabled = true)
    public void SanityTest(){

        Start start = new Start();
        start.clickOnView();
    }

    @Test(description = "check box example", enabled = true)
    public void checkBoxExample(){
        Start start = new Start();
        start.clickOnView();
        View view = new View();
        view.clickOption();
    }
}
