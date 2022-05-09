package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateParser {

    public static Date parseDate(String dateInput) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dMMMyyyy", Locale.ENGLISH);
        Date date = formatter.parse(dateInput);
        return date;
    }

}
