import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
        return "Gli eventi ordinati per data sono: " + events;
    }

    @Override
    public String toString() {
        return "Gli eventi in programma sono: \n" + events;
    }
}
