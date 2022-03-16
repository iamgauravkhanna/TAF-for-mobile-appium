package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import utils.JavaUtil;

public class ExtentManager {

    private static ExtentReports extent;

    private static String reportFileName = "Test-Automaton-Report-" + JavaUtil.getCurrentTimeStamp() + ".html";

    private static String fileSeperator = System.getProperty("file.separator");

    private static String reportFileLocation = System.getProperty("logsDirectory") + fileSeperator + reportFileName;

    public static ExtentReports getInstance() {

        if (extent == null) {
            createInstance();
        }
        return extent;
    }

    private static void createInstance() {

        ExtentSparkReporter spark = new ExtentSparkReporter(reportFileLocation);

        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Author", "Gaurav Khanna");
        extent.setSystemInfo("Organization", "Opensource");
    }
}
