import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProgrammUnicEvents{

    String title;
    Set<Event> eventsSet;

    public ProgrammUnicEvents(String title){
        setTitle(title);
        eventsSet = new HashSet<>();
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public void addEvent(Event event){
        eventsSet.add(event);
    }
    
    public String howMany(){
        return "Nel Set ci sono " + eventsSet.size() + " elementi!";
    }

    public void cancelAllSet(){
        eventsSet.clear();
        System.out.println("Il set è stato svuotato!");
    }

    public String getEventsSortedByDate(LocalDate date){
        List<Event> eventsSetSorted= new ArrayList<>(eventsSet);
        Collections.sort(eventsSetSorted, new ProductSortinComparator());
        String print = "";
        for (Event event : eventsSetSorted) {
            print += event.getDate() + " - " + event.getTitle() + "\n";
        }
        
        return "Gli eventi ordinati per data partendo dal Set sono: " + print;
    }

    public Set<Event> getEventsOnSelectedDate(LocalDate date){
        Set<Event> eventsOnSelectedDate = new HashSet<>();
        for (Event event : eventsSet) {
            if (event.getDate().isEqual(date)) {
                eventsOnSelectedDate.add(event);
            }
        }
        return eventsOnSelectedDate;
    }

    public Event getMaxPostiTotaliEvento(){
        int max = Integer.MIN_VALUE;
        Event x = null;
        for (Event event : eventsSet) {
            if (event.getTotalSeats() > max) {
                max = event.getTotalSeats();
                x = event;
            }
        }
        return x;
    }

    public Event getMinPostiTotaliEvento(){
        int min = Integer.MAX_VALUE;
        Event x = null;
        for (Event event : eventsSet) {
            if (event.getTotalSeats() > min) {
                min = event.getTotalSeats();
                x = event;
            }
        }
        return x;
    }

    @Override
    public String toString() {
        return "Gli eventi in programma sono: \n" + eventsSet;
    }
}
