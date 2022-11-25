import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ProgrammEvents {
    
    String title;
    List<Event> events;

    public ProgrammEvents(String title){
        setTitle(title);
        events = new ArrayList<>();
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public void addEvent(Event event){
        events.add(event);
    }
    
    public String howManyEvents(){
        return "Nel programma ci sono: " + events.size() + " eventi";
    }

    public void cancelAllEvents(){
        events.clear();
        System.out.println("La lista di eventi è stata svuotata!");
    }

    public List<Event> getEventsOnSelectedDate(LocalDate date){
        List<Event> eventsOnSelectedDate = new ArrayList<>();
        for (Event event : events) {
            if (event.getDate().isEqual(date)) {
                eventsOnSelectedDate.add(event);
            }
        }
        return eventsOnSelectedDate;
    }

    public String getEventsSortedByDate(){
        //comparator svolto con Lamba Exspression
        Comparator<Event> comparatorAsc = (event1, event2) -> event1.getDate().compareTo(event2.getDate());
        Collections.sort(events, comparatorAsc);
        
        String print = "";
        for (Event event : events) {
            print += event.getDate() + " - " + event.getTitle() + "\n";
            
        }
        
        return "Gli eventi ordinati per data sono: " + print;
    }

    public Event getEvent(int i){
        return events.get(i);
    }

    @Override
    public String toString() {
        return "Gli eventi in programma sono: \n" + events;
    }
}
