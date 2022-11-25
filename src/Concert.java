import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalTime;

public class Concert extends Event{

    LocalTime hour;
    BigDecimal price;
    
    public Concert(String title, LocalDate date, int totalSeats, LocalTime hour, BigDecimal price) throws Exception{
        super(title, date, totalSeats);
        setHour(hour);
        setPrice(price);
    }

    public LocalTime getHour() {
        return hour;
    }

    private void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }   

    private LocalDate getFormattedDate(LocalDate date){

        return date;
    }

    private LocalTime getFormattedHour(LocalTime hour){
        return hour;
    }

    private BigDecimal getFormattedPrice(BigDecimal price){
        price = price.round(new MathContext(4));
        return price;
    }

    @Override
    public String toString() {  
        return "Le informazioni del concerto sono: " + "\n" + super.toString()
        + "\nHour: " + getFormattedHour(hour) + "\nPrice: " + getFormattedPrice(price) + "$";
    }
}
