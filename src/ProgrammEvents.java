import java.util.ArrayList;
import java.util.List;

public class ProgrammEvents {
    
    String title;
    List<Event> events;

    public ProgrammEvents(String title){
        setTitle(title);
        events = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
}
