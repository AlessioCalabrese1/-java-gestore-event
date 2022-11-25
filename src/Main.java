import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LocalDate eventDate = LocalDate.parse("2023-06-13");
        Scanner sn = new Scanner(System.in);
        Event event = null;
        try {
            event = new Event("Nuovo Nuovo", eventDate, 15);
            System.out.println(event);
            System.out.println("-------------------------------");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        boolean sentinel = true;
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
