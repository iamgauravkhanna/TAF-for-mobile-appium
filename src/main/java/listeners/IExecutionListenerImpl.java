package listeners;

import constants.TestConstants;
import logger.MyLogger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.IExecutionListener;
import reporting.ExtentManager;
import utils.JavaUtil;

import java.io.File;

public class IExecutionListenerImpl implements IExecutionListener {

    @Override
    public void onExecutionStart() {

        String outputDirectory;
        outputDirectory = System.getProperty("user.dir") + File.separator + "reports" + File.separator
                + "test-reports-" + JavaUtil.getCurrentTimeStamp();

        JavaUtil.createDirectory(outputDirectory);

        System.setProperty("logsDirectory", outputDirectory);

        ExtentManager.getInstance();

        PropertyConfigurator.configure(TestConstants.LOG4J_PATH);
        MyLogger.INFO("Executed Started");
    }

    @Override
    public void onExecutionFinish() {
        MyLogger.INFO("TestNG has finished, took around");
        ExtentManager.getInstance().flush();
    }
}
