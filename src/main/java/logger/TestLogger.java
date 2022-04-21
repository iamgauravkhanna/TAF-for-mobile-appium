package logger;

import org.apache.log4j.Logger;
import property.PropertyUtils;
import reporting.ExtentTestManager;

public class TestLogger {

    private static Logger Log = Logger.getLogger("CustomLog");

    public static void logInfoExtent(String message) {
        INFO(message);
        ExtentTestManager.getTest().info(message);
    }

    public static void logDetailedInfoExtent(String message) {
        INFO(message);
        if(PropertyUtils.getPropertyValue("need_detailed_reporting").equalsIgnoreCase("yes")) {
            ExtentTestManager.getTest().info(message);
        }
    }

    public static void INFO(String message) {
        Log.info(message);
        System.out.println(" *** INFO : " + message);
    }

    public static void ERROR(String message) {
        Log.error(message);
        System.out.println(" *** ERROR : " + message);
    }

}
