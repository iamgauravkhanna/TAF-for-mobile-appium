package screens.android.project01;

import driver.DriverManager;
import enums.MobileFindBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.FindBy;
import screens.BaseScreen;

public class ViewsScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Controls")
    private MobileElement controls;

    @AndroidFindBy(accessibility = "Gallery")
    private MobileElement Gallery;

    @AndroidFindBy(id = "io.appium.android.apis:id/monitored_switch")
    private MobileElement monitoredSwitch;

    public void clickOption() {
        longPress(controls, 5);
    }

    public void goToSwitches() {
        scrollToElementAndClick("Switches");
    }

    public void goTab() {
    }

    public String getSwitchText() {
        return monitoredSwitch.getText();
    }

    public void moveSeekBar() {
        MobileElement seekBar = getMobileElement("io.appium.android.apis:id/seek", MobileFindBy.ID);

        int startX = seekBar.getLocation().getX();
        System.out.println("startx Location : " + startX);

        int endX = seekBar.getSize().getWidth();
        System.out.println("endx Location :" + endX);

        int yAxis = seekBar.getLocation().getY();

        int moveToXDirectionAt = (int) (endX * 0.9);
        System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction.");

        new TouchAction(DriverManager.getDriver())
                .press(PointOption
                        .point(startX, yAxis))
                .moveTo(PointOption
                        .point(moveToXDirectionAt, yAxis))
                .release()
                .perform();

        pause();
    }

    public void dragDropCase() {

        ((AndroidDriver) DriverManager.getDriver()).startActivity(new Activity("io.appium.android.apis", ".view.DragAndDropDemo"));

        MobileElement dragDot1 = getMobileElement("io.appium.android.apis:id/drag_dot_1", MobileFindBy.ID);

        MobileElement dragDot3 = getMobileElement("io.appium.android.apis:id/drag_dot_3", MobileFindBy.ID);

        Point center1 = dragDot1.getCenter();

        Point center2 = dragDot3.getCenter();

        new TouchAction(DriverManager.getDriver())
                .longPress(PointOption
                        .point(center1.x, center1.y))
                .moveTo(PointOption
                        .point(center2.x, center2.y))
                .release()
                .perform();

        pause();
    }

    public void printDropDownValues() {
    }
}