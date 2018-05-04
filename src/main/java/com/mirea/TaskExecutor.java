package com.mirea;

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
    public void run() {
       executeTask();
    }
    private void executeTask(){
        Random rd = new Random();
        Task currTask=null;
        if(!inQueue.isEmpty()) {
            synchronized (inQueue) {
                currTask = inQueue.poll();
            }
        }
        if(currTask!=null) {
            synchronized (outQueue) {
                currTask.weather = rd.nextInt(61) - 30 + "°C";
                outQueue.add(currTask);
            }
        }

    }
}

