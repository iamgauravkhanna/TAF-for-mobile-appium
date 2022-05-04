package screens.ios.project01;

import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import logger.TestLogger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import screens.BaseScreen;

public class GeneralScreen extends BaseScreen {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"General\"]")
    MobileElement general;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"About\"]")
    MobileElement about;

    //@iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeStaticText[1]")
    //MobileElement option;

    public void clickGeneral() {
        waitForVisibility(general);
        click(general);
    }

    public void clickAbout() {
        waitForVisibility(about);
        click(about);
        pause();
        for (int i = 1; i < 6; i++) {
            MobileElement optionKey = getMobileElement("//XCUIElementTypeTable/XCUIElementTypeCell[" + i + "]/XCUIElementTypeStaticText[" + 1 + "]", MobileFindBy.XPATH);
            TestLogger.INFO("key " + getElementText(optionKey));
            MobileElement optionValue = getMobileElement("//XCUIElementTypeTable/XCUIElementTypeCell[" + i + "]/XCUIElementTypeStaticText[" + 2 + "]", MobileFindBy.XPATH);
            TestLogger.INFO("value " + getElementText(optionValue));
            i++;
        }
    }

}
