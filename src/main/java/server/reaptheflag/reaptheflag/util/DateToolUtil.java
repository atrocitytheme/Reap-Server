package server.reaptheflag.reaptheflag.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToolUtil {
    private DateToolUtil () {}
    public static String logCurrentDate() {
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return format.format(new Date());
    }
}
