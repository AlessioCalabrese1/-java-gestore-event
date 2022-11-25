import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class Event {
    private String title;
    private String date;
    private int totalSeats;
    private int reservedSeats = 0;

    public Event(String title, String date, int totalSeats) throws Exception{
        setTitle(title);
        setDate(date);
        setTotalSeats(totalSeats);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) throws Exception{
        try {
            SimpleDateFormat pattern = new SimpleDateFormat("dd/MM/yyyy");
            Date eventD = (Date) pattern.parse(date);
            Calendar c = Calendar.getInstance();
            Date now = (Date) c.getTime();
            long elapsedms = eventD.getTime() - now.getTime();
            long diff = TimeUnit.MINUTES.convert(elapsedms, TimeUnit.MILLISECONDS);
            System.out.println("Diff: " + diff);
            if (diff < 0) {
                throw new Exception("La data inserita deve essere maggiore di quella corrente!");
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    private void setTotalSeats(int totalSeats) throws Exception{
        if (totalSeats < 0) {
            throw new Exception("Il numero di posti totali deve essere positivo!");
        }
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "L'evento aggiunto è: " + "\nTitle: " + title + "\nDate: " + date + "\nPosti totali: "
         + totalSeats + "\nPosti riservati: " + reservedSeats;
    }
}
