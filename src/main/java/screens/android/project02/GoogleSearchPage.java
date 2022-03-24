package screens.android.project02;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class GoogleSearchPage extends BaseScreen {

    @FindBy(xpath="//input[@aria-label='Search']")
    private static MobileElement txtFieldSearch;

    public GoogleSearchPage performSearch(String searchText) {

        enterValueAndPressEnter(txtFieldSearch, searchText, "Search text box");
        return new GoogleSearchPage();
    }

}
