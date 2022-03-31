package android.project02;

import base.BaseTest;
import enums.ConfigJson;
import json.JsonUtils;
import org.testng.annotations.Test;
import screens.android.project02.GoogleHomePage;
import screens.android.project02.GoogleSearchPage;

public class GoogleTest extends BaseTest {

    @Test(description = "Google search",enabled = true)
    public void userShouldBeAbleToSearchText() {

        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.openHomePage(JsonUtils.getConfig(ConfigJson.URL));
        GoogleSearchPage googleSearchPage = new GoogleSearchPage();
        googleSearchPage.performSearch("hello world");
    }
}
