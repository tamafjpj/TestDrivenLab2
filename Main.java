import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        final int numOfThreads=4;
         Comparator<Task> idComparator = new Comparator<Task>(){

            @Override
            public int compare(Task c1, Task c2) {
                return  (c1.getId() - c2.getId());
            }
        };
        Queue<Task> inQueue=new PriorityQueue<>(50,idComparator);
        Queue<Task> outQueue=new PriorityQueue<>(50,idComparator);
        Logger logger=new Logger();
        new TaskGenerator(inQueue,4);
        System.out.println("InQueue:");
        logger.logQueue(inQueue);
        for(int i=0;i<numOfThreads;i++){TaskExecutor te = new TaskExecutor(inQueue,outQueue); try {
            te.thrd.join();
        }catch (InterruptedException e){e.printStackTrace();}}
        System.out.println("OutQueue:");
        logger.logQueue(outQueue);
    }
}
