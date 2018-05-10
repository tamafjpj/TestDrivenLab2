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
    }
    public void run() {
       while (!thrd.isInterrupted()){
           executeTask();
       }
    }
    private void executeTask(){
        Random rd = new Random();
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
                currTask.weather = rd.nextInt(61) - 30 + "°C";
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

