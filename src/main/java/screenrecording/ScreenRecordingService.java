package screenrecording;

import enums.ConfigProperties;
import property.PropertyUtil;

public class ScreenRecordingService {

    public ScreenRecordingService() {
    }

    public static void startRecording() {
        if (PropertyUtil.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.startScreenRecording();
        }
    }

    public static void stopRecording(String methodName) {
        if (PropertyUtil.getPropertyValue(ConfigProperties.RECORD_SCREEN).equalsIgnoreCase("yes")) {
            ScreenRecordingUtils.stopScreenRecording(methodName);
        }

    }
}