package ios.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.StartScreen;


public class TestClassA extends BaseTest {

    @Test(description = "Find Element Example",enabled = true)
    public void TestA(){

        StartScreen start = new StartScreen();
        start.verifyOptions();
    }
}
