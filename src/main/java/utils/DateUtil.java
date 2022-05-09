package utils;

import java.util.Date;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil {
    public static boolean isWeekend(Date date){

        DateFormat formatter = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        String dayOfWeek = formatter.format(date).toString().toUpperCase();
        return (dayOfWeek.equals("SATURDAY") || dayOfWeek.equals("SUNDAY") );
        
    }
}
