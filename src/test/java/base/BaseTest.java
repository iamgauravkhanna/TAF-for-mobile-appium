package base;

import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup(){
        System.out.println("Steps to be performed before starting suite");
    }

}
