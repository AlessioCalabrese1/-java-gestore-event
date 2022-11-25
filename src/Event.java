import java.sql.Date;

public class Event {
    private String title;
    private Date date;
    private int totalSeats;
    private int reservedSeats = 0;

    public Event(String title, Date date, int totalSeats){
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getReservedSeats() {
        return reservedSeats;
    }

    private void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    
}
