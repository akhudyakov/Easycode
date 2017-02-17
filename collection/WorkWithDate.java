package hometask.collection;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Andrey on 10.02.2017.
 */
public class WorkWithDate {

    public static String getOnlyStringDateFromDate(Date d) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateString = dateFormat.format(d);
        return dateString;
    }


    public static Date getOnlyDateFromStringDate(String s) throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(s);
        return date;
    }


    public static Date getOnlyDate (Date d) throws ParseException {

        String s = getOnlyStringDateFromDate(d);
        Date date = getOnlyDateFromStringDate(s);
        return date;

    }
}
