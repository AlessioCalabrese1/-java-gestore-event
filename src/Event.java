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


    public void book(int nReservations){
        try {
            bookException(nReservations);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void bookException(int nReservations) throws Exception{
        LocalDate now = LocalDate.now();
        int placesAvailable = totalSeats - reservedSeats - nReservations;
        if (date.isAfter(now) && placesAvailable >= 0) {
            reservedSeats += nReservations;
            System.out.println("L'operazione è andata a buon fine!");
        }else{
            throw new Exception("Non ci sono abbastanza posti disponibili!");
        }
    }

    public void cancel(int nCancel){
        try {
            cancelException(nCancel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void cancelException(int nCancel) throws Exception{
        LocalDate now = LocalDate.now();
        int numberSeatsCanceled = reservedSeats - nCancel;
        if (date.isAfter(now) && numberSeatsCanceled >= 0) {
            reservedSeats -= nCancel;
            System.out.println("L'operazione è andata a buon fine!");
            System.out.println("-------------------------------");
        }else if(date.isAfter(now) && numberSeatsCanceled < 0){
            throw new Exception("Le prenotazioni da cancellare sono maggiori delle prenotaioni effettuate!");
        }else{
            throw new Exception("Non ci sono prenotazioni!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Event event1 = (Event)obj;
        if (event1.title.compareTo(this.title) == 0 && event1.date.isEqual(this.date)) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "Title: " + title + "\nDate: " + date + "\nPosti totali: "
        + totalSeats + "\nPosti riservati: " + reservedSeats;
    }
}
