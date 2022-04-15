package utils;

import constants.TestConstants;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;

import static constants.TestConstants.*;

public class AppiumServerUtils {

    private static AppiumDriverLocalService service ;

    public static void startAppiumServer(){
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.usingDriverExecutable(new File(NODE_JS_PATH));
        builder.withAppiumJS(new File(APPIUM_JS_PATH));
        builder.withIPAddress(APPIUM_SERVER_HOST);
        builder.usingPort(APPIUM_SERVER_PORT);
        builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(GeneralServerFlag.ALLOW_INSECURE, "chromedriver_autodownload");
        builder.withLogFile(new File(getAppiumServerLogsPath()));

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        service.clearOutPutStreams();
    }

    public static void stopAppiumServer(){}

    public static void checkIfServerIsRunning(){}
}
