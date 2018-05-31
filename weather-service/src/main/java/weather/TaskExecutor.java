package weather;

import data.WeatherDataSource;
import data.WeatherDataSourceImpl;

import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class TaskExecutor implements Runnable {
    public Thread thrd;
    private Queue<Task>inQueue;
    private Queue<Task>outQueue;
    private WeatherDataSource wds = new WeatherDataSourceImpl();
    public TaskExecutor(Queue<Task>inQueue,Queue<Task>outQueue){
        this.thrd=new Thread(this,"Executor");
        this.inQueue=inQueue;
        this.outQueue=outQueue;
    }
    public void run() {
       while (!thrd.isInterrupted()){
           executeTask();
       }
    }
    private void executeTask(){
        Task currTask=null;
        if(!inQueue.isEmpty()) {
            synchronized (inQueue) {
                if(!inQueue.isEmpty()) {
                    currTask = inQueue.poll();
                }
            }
        }
        if(currTask!=null) {
            synchronized (outQueue) {
                currTask.weather = wds.getByCity(currTask.getCity());
                if(outQueue.size()<=30000) {
                    outQueue.add(currTask);
                }else
                    try{
                        outQueue.wait();
                    }catch (InterruptedException e){e.printStackTrace();}
            }
        }

    }
}

