import java.util.Queue;
import java.util.Random;

public class TaskExecutor implements Runnable {
    public Thread thrd;
    private Queue<Task>inQueue;
    private Queue<Task>outQueue;
    public TaskExecutor(Queue<Task>inQueue,Queue<Task>outQueue){
        this.thrd=new Thread(this,"Executor");
        this.inQueue=inQueue;
        this.outQueue=outQueue;
        thrd.start();
    }
    @Override
    public void run() {
       executeTask();
    }
    private void executeTask(){
        Random rd = new Random();
        Task currTask;
        synchronized (inQueue){
            while (!inQueue.isEmpty()) {
                currTask = inQueue.poll();
                currTask.weather=rd.nextInt(61)-30 +"°C";

                synchronized (outQueue){
                    outQueue.add(currTask);
                }
            }
        }

    }
}
