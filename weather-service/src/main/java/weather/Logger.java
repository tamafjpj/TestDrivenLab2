package weather;
import java.util.Queue;

public class Logger implements Runnable{
    public Queue<Task> inQueue;
    Thread logger;
    public Logger(Queue<Task>inQueue){
        this.inQueue=inQueue;
        this.logger=new Thread(this,"Logger");
    }

    @Override
    public void run() {
        while (!logger.isInterrupted()){log(inQueue);}
    }

    public String log(Queue<Task>inQueue){
      if(!inQueue.isEmpty()){
          synchronized (inQueue) {
              if(!inQueue.isEmpty()) {
                  Task i = inQueue.poll();
                  System.out.println("id: " + i.getId() + " Date: " + i.getDate() + " City: " + i.getCity() + " Weather: " + i.getWeather() + ";");
                  inQueue.notifyAll();
              }
          }
      }
      return "Log in console.";
    }
}
