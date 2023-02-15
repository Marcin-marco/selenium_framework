package pl.marcin.webdriver.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    public static String getCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return formatter.format(new Date());
    }
}
