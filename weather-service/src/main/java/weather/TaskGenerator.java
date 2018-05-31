package weather;

import data.WeatherDataSource;
import data.WeatherDataSourceImpl;

import java.util.Date;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class TaskGenerator implements Runnable{
    WeatherDataSource wds = new WeatherDataSourceImpl();
    private String cities[]=wds.getCities().toArray(new String[wds.getCities().size()]);
    private Random rnd =new Random();
    private static int id=0;
    Thread generator;
    Queue<Task> inQueue;
    public TaskGenerator(Queue<Task> inQueue){
        this.generator=new Thread(this,"Generator");
        this.inQueue=inQueue;
    }
    private static void incID(){
        id++;
    }
    public void generate(Queue<Task> inQueue){
            synchronized (inQueue){
                if(!(inQueue.size()>=30000)) {
                    inQueue.add(new Task(id, new Date(), cities[rnd.nextInt(cities.length)]));
                    incID();
                }}
        }

    @Override
    public void run() {
       while(!generator.isInterrupted()){
           generate(inQueue);
       }
    }

}
