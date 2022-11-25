import java.time.LocalDate;

public class Event {
    private String title;
    private LocalDate date;
    private int totalSeats;
    private int reservedSeats = 0;

    public Event(String title, LocalDate date, int totalSeats) throws Exception{
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws Exception{
        LocalDate now = LocalDate.now();
        if (date.isAfter(now)) {
            this.date = date;
        }else{
            throw new Exception("Inserire una data valida!");
        }
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    
    private void setTotalSeats(int totalSeats) throws Exception{
        if (totalSeats < 0) {
            throw new Exception("Il numero di posti totali deve essere positivo!");
        }
        this.totalSeats = totalSeats;
    }
    
    public int getReservedSeats() {
        return reservedSeats;
    }


    public void book(){
        try {
            bookException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void bookException() throws Exception{
        LocalDate now = LocalDate.now();
        int placesAvailable = totalSeats - reservedSeats;
        if (date.isAfter(now) && placesAvailable > 0) {
            reservedSeats++;
            System.out.println("Il biglietto è stato prenotato con successo!");
        }else{
            throw new Exception("Non ci sono più posti disponibili!");
        }
    }

    @Override
    public String toString() {
        return "L'evento aggiunto è: " + "\nTitle: " + title + "\nDate: " + date + "\nPosti totali: "
        + totalSeats + "\nPosti riservati: " + reservedSeats;
    }
}
