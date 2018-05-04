package com.mirea;
import java.util.Queue;

public class Logger {
    public String logQueue(Queue<Task>inQueue){
      if(inQueue.isEmpty()){return null;}else {
          for (Task i : inQueue) {
              System.out.println("id: " + i.getId() + " Date: " + i.getDate() + " City: " + i.getCity() + " Weather: " + i.getWeather() + ";");
          }
      }
      return "Log in console.";
    }
}
