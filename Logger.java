import java.util.Queue;

public class Logger {
    public void logQueue(Queue<Task>inQueue){
      for(Task i:inQueue){
          System.out.println("id: "+i.getId()+" Date: "+i.getDate()+" City: "+i.getCity()+" Weather: "+i.getWeather()+";");
      }
    }
}
