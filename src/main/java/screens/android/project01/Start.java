package screens.android.project01;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import utils.BaseScreen;

public class Start extends BaseScreen {

    @AndroidFindBy(id="Views")
    private static MobileElement view;

    public void performSanity() {

        Boolean isDisplayed;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        isDisplayed = view.isDisplayed();

        System.out.println("Elements Visible on UI ? - " + isDisplayed);
    }
}
