package gwtest;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Created by bobsol on 29.01.17.
 */
public class FormatRus {

    public static LocalDate rusDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor temporalAccessor = formatter.parse(date);
        LocalDate localDate = LocalDate.from(temporalAccessor);
        return localDate;
    }

    public static LocalTime rusTime(String time){

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:MM");
        TemporalAccessor temporalAccessor = formatter2.parse(time);

        LocalTime localTime = LocalTime.from(temporalAccessor);
        return localTime;
    }

}
