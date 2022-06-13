package logger;

import org.apache.log4j.Logger;
import property.PropertyUtils;
import reporting.ExtentTestManager;

public class TestLogger {

    private static Logger Log = Logger.getLogger("CustomLog");

    public static void INFO_EXTENT(String message) {
        INFO(message);
        ExtentTestManager.getTest().info(message);
    }

    public static void INFO_DETAILED_EXTENT(String message) {
        INFO(message);
        if (PropertyUtils.getPropertyValue("need_detailed_reporting").equalsIgnoreCase("yes")) {
            ExtentTestManager.getTest().info(message);
        }
    }

    public static void INFO(String message) {
        Log.info(message);
        if (PropertyUtils.getPropertyValue("need_detailed_reporting").equalsIgnoreCase("yes")) {
            System.out.println(" *** INFO : " + message);
        }
    }

    public static void ERROR(String message) {
        Log.error(message);
        System.out.println(" *** ERROR : " + message);
    }
}
