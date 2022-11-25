import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        try {
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"), Locale.ITALY);
            SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
            calendar.set(2023, 6, 13);
            String eventDate = pattern.format(calendar.getTime());
            System.out.println(eventDate);

            Event event = new Event("Nuovo Nuovo", eventDate, 200);
            System.out.println(event);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
