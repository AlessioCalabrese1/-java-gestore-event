import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        ProgrammEvents progEvents = new ProgrammEvents("Eventi a Milano");
        try {
            LocalDate eventDate1 = LocalDate.parse("2027-06-13");
            Event event1 = new Event("Nuovo Nuovo 1", eventDate1, 150);

            LocalDate eventDate2 = LocalDate.parse("2024-09-25");
            Event event2 = new Event("Nuovo Nuovo 2", eventDate2, 300);

            LocalDate eventDate3 = LocalDate.parse("2025-09-25");
            Event event3 = new Event("Nuovo Nuovo 3", eventDate3, 200);
            
            progEvents.addEvent(event1);
            progEvents.addEvent(event2);
            progEvents.addEvent(event3);

            System.out.println(progEvents);
            System.out.println("-------------------------------");

            System.out.println(progEvents.howManyEvents());
            System.out.println("-------------------------------");

            List<Event> eventsOnDate = progEvents.getEventsOnSelectedDate(eventDate3);
            System.out.println("Gli eventi alla data " + eventDate3 + " sono:\n" + eventsOnDate);
            System.out.println("-------------------------------");

            System.out.println(progEvents.getEventsSortedByDate());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        

        LocalDate concertDate = null;
        LocalTime concertHour = null;
        BigDecimal concertPrice = new BigDecimal("39.99111111");
        Event concert = null;
        try {
            concertDate = LocalDate.parse("2027-06-13");
            concertHour = LocalTime.parse("21:30");
            concert = new Concert("Ernia Concert", concertDate, 500, concertHour, concertPrice);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        System.out.println(concert);


        boolean sentinel = true;
        Event event = concert;
        System.out.println("-------------------------------");
        while (sentinel) {
            System.out.println("Si vuole fare delle prenotazioni? (y/n)");
            String conf = sn.next();
            if (conf.equals("y")) {
                System.out.println("-------------------------------");
                System.out.println("Quante prenotazioni si vuole effettuare?");
                
                int nReservations = sn.nextInt();
                event.book(nReservations);
                System.out.println(event);

                System.out.println("-------------------------------");
                System.out.println("Si vogliono cancellare delle prenotazioni? (y/n)");
                conf = sn.next();
                if (conf.equals("y")) {
                    System.out.println("-------------------------------");
                    System.out.println("Quante prenotazioni si desidera cancellare?");
                    int nCancel = sn.nextInt();
                    event.cancel(nCancel);
                    System.out.println(event);
                    System.out.println("-------------------------------");
                }
            }else if(conf.equals("n")){
                System.out.println("-------------------------------");
                System.out.println(event);
                System.out.println("Arrivederci e buona giornata!");
                sentinel = false;
            }else{
                System.out.println("Il valore inserito non è corretto! Riprovare!");
                System.out.println("-------------------------------");
            }
        }
    }
}
