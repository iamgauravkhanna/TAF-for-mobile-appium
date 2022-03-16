package screenrecording;

import constants.TestConstants;
import driver.DriverManager;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenRecordingUtils {

    private ScreenRecordingUtils() {
    }

    public static void startScreenRecording() {
        ((CanRecordScreen) DriverManager.getDriver()).startRecordingScreen();
    }

    public static void stopScreenRecording(String methodName) {
        String recordedVideoFile = ((CanRecordScreen) DriverManager.getDriver()).stopRecordingScreen();
        String pathToWriteVideoFile = TestConstants.getScreenRecordingsPath() + File.separator + methodName + ".mp4";
        writeToOutputStream(pathToWriteVideoFile, recordedVideoFile);
    }

    static void writeToOutputStream(String filePathToWrite, String recordedVideoFile) {
        try (FileOutputStream outputStream = new FileOutputStream(filePathToWrite)) {
            outputStream.write(Base64.decodeBase64(recordedVideoFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
