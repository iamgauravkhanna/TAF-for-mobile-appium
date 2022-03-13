package screenrecording;

import enums.ConfigProperties;
import property.PropertyUtils;

public class ScreenRecordingService {

    public ScreenRecordingService() {
    }

    public static void startRecording() {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.startScreenRecording();
        }
    }

    public static void stopRecording(String methodName) {
        if (PropertyUtils.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.stopScreenRecording(methodName);
        }

    }
}