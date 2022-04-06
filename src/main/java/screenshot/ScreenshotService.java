package screenshot;

public final class ScreenshotService {

    private ScreenshotService() {}

    // Abstract layer to handle the change in business requirement
    public static String getScreenshotAsBase64() {
        return ScreenshotUtils.captureScreenshotAsBase64();
    }

    public static void captureScreenshotAsFile(){
        ScreenshotUtils.captureScreenshotAsFile();
    }

}
