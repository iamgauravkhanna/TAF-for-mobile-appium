package android.project01;

import base.BaseTest;
import org.testng.annotations.Test;
import screens.android.project01.Start;


public class TestClassA extends BaseTest {

    @Test(description = "Test Case #1", enabled = true)
    public void TestA(){

        Start start = new Start();
        start.performSanity();
    }
}
