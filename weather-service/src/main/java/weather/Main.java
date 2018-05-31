package weather;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        final int numOfThreads=10;
         Comparator<Task> idComparator = new Comparator<Task>(){
             @Override
            public int compare(Task c1, Task c2) {
                return  (c1.getId() - c2.getId());
            }
        };
        Queue<Task> inQueue=new PriorityQueue<>(50,idComparator);
        Queue<Task> outQueue=new PriorityQueue<>(50,idComparator);
        Logger logger=new Logger(outQueue);
        logger.logger.start();
        TaskGenerator tg=new TaskGenerator(inQueue);
        tg.generator.start();
        for(int i=0;i<numOfThreads;i++){
            TaskExecutor te=new TaskExecutor(inQueue,outQueue);
            te.thrd.setDaemon(true);
            te.thrd.start();
        }
    }
}
