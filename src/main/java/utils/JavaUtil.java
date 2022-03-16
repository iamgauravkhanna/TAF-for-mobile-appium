package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class JavaUtil {

    public static String getCurrentDateTime() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd-HH_mm_ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dateTimeFormatter.format(localDateTime);
    }

    public static String getCurrentTimeStamp() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static String getTimeStamp() {
        SimpleDateFormat dateFormat1 = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
        String timeStamp = dateFormat1.format(new Date());
        return timeStamp;
    }

    public static void createDirectory(String directoryName) {

        File dir = new File(directoryName);
        boolean successful = false;
        try {
            dir.mkdir();
            successful = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
