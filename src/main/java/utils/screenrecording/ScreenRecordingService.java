package utils.screenrecording;

import enums.ConfigProperties;
import utils.configloader.PropertyUtils;

public final class ScreenRecordingService {

    private ScreenRecordingService() {
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