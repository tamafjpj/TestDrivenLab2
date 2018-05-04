package com.mirea;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

public class LoggerTest {

    @Test
    public void logQueue() {
        Date dt =new Date();
        Task t1 = new Task(1,dt,"Moscow");
        Task t2 = new Task(2,dt,"SPB");
        Task t3 = new Task(2,dt,"Omsk");
        Comparator<Task> idComparator = new Comparator<Task>(){
            @Override
            public int compare(Task c1, Task c2) {
                return  (c1.getId() - c2.getId());
            }
        };
        Queue<Task> inQueue = new PriorityQueue<>(3,idComparator);
        inQueue.add(t1);
        inQueue.add(t2);
        inQueue.add(t3);
        Logger logger=new Logger();
        String re =logger.logQueue(inQueue);
        assertNotNull(re);
        inQueue.poll();
        inQueue.poll();
        inQueue.poll();
        re=logger.logQueue(inQueue);
        assertNull(re);
    }
}