package basejava.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }

    public static String formatDate(LocalDate localDate) {
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/yyyy");
        return localDate.format(formatters);
    }
}