package android.project02;

import base.BaseTest;
import constants.TestConstants;
import driver.DriverManager;
import enums.ConfigJson;
import json.JsonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.android.project02.GoogleSearchPage;

public class GoogleTest extends BaseTest {

    @Test(description = "Google search",enabled = true)
    public void userShouldBeAbleToSearchText() {
        DriverManager.getDriver().get(JsonUtils.getConfig(ConfigJson.URL));
       new GoogleSearchPage()
                .performSearch("hello world");
    }
}
