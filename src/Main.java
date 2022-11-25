import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LocalDate eventDate = LocalDate.parse("2023-06-13");
        try {
            Event event = new Event("Nuovo Nuovo", eventDate, 200);
            System.out.println(event);
            event.book();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
