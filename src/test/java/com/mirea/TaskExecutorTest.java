package com.mirea;

import org.junit.Test;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

public class TaskExecutorTest {

    @Test
    public void executionTest() {
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
        Queue<Task> outQueue = new PriorityQueue<>(3,idComparator);
        inQueue.add(t1);
        inQueue.add(t2);
        inQueue.add(t3);
        for (int i=0;i<3;i++){
           TaskExecutor te = new TaskExecutor(inQueue,outQueue);
           try {
               te.thrd.join();
           }catch (InterruptedException e){e.printStackTrace();}
        }
        assertEquals(0,inQueue.size());
        assertEquals(3,outQueue.size());
        for(Task i:outQueue){assertNotNull(i.getWeather());}
    }
}