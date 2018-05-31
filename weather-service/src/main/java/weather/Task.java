package weather;
import java.util.Date;

public class Task {
    private int id;
    private Date date;
    private String city;
    public String weather;

    public Task(int id,Date date,String city){
        setId(id);
        setCity(city);
        setDate(date);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getWeather(){
        return weather;
    }


}
