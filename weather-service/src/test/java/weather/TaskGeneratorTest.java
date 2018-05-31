package com.mirea;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.junit.Assert.*;

public class TaskGeneratorTest {
   /* @Test
    public void generateTasks(){
        Comparator<Task> idComparator = new Comparator<Task>(){
            @Override
            public int compare(Task c1, Task c2) {
                return  (c1.getId() - c2.getId());
            }
        };
        Queue<Task>inQueue = new PriorityQueue<>(1,idComparator);
        assertTrue(inQueue.isEmpty());
        new TaskGenerator(inQueue,15);
        assertEquals(15,inQueue.size());
    }*/

}