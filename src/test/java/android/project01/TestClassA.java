package android.project01;

import base.BaseTest;
import driver.DriverManager;
import org.testng.annotations.Test;
import screens.android.project01.Start;


public class TestClassA extends BaseTest {

    @Test(description = "Find Element Example")
    public void TestA(){

        Start start = new Start();
        start.performSanity();
    }
}
