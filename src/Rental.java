import java.time.LocalDate;
import java.util.Date;

public class Rental {
     int car_id;
     int client_id;

     Date start_date;
     Date end_date;

    public Rental(int car_id, int client_id, Date start_date, Date end_date) {
        this.car_id = car_id;
        this.client_id = client_id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public int getCar_id() {
        return car_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }
}
