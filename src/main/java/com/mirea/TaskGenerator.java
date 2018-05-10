package com.mirea;

import java.util.Date;
import java.util.Queue;
import java.util.Random;

public class TaskGenerator implements Runnable{
    private final String[] cities = new String[]{"Moscow","Kaliningrad","Pyatigorsk","Saint-petersburg","Chelyabinsk",
                                            "Nizhny-novgorod","Novosibirsk","Vladivostok","Krasnoyarsk","Kazan",
                                            "Ufa","Rostov-na-donu","Samara","Yekaterinburg","Omsk"};
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
            inQueue.add(new Task(id,new Date(),cities[rnd.nextInt(cities.length)]));
            incID();}
        }

    @Override
    public void run() {
       while(!generator.isInterrupted()){
           generate(inQueue);
       }
    }

    public String[] getCities() {
        return cities;
    }
}
