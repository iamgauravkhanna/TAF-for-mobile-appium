package android.project02;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.android.project02.GoogleSearchPage;

public class GoogleTest extends BaseTest {

    @Test(description = "Google search",enabled = false)
    public void googleSearch() {
       new GoogleSearchPage()
                .performSearch("helloword");
    }
}
