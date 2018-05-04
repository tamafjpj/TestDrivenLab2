package com.mirea;

import java.util.Date;
import java.util.Queue;
import java.util.Random;

public class TaskGenerator {
    private final String[] cities = new String[]{"Moscow","Kaliningrad","Pyatigorsk","Saint-petersburg","Chelyabinsk",
                                            "Nizhny-novgorod","Novosibirsk","Vladivostok","Krasnoyarsk","Kazan",
                                            "Ufa","Rostov-na-donu","Samara","Yekaterinburg","Omsk"};
    private Random rnd =new Random();
    private static int id=0;

    public TaskGenerator(Queue<Task> inQueue, int numOfTasks){
        fillQueue(inQueue,numOfTasks);
    }
    private static void incID(){
        id++;
    }
    private void fillQueue(Queue<Task> inQueue,int N){
        for(int i=0;i<N;i++){
            inQueue.add(new Task(id,new Date(),cities[rnd.nextInt(cities.length)]));
            incID();
        }
        id=0;
    }

    public String[] getCities() {
        return cities;
    }
}
