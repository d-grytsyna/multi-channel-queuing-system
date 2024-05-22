package org.dgrytsyna;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class HandlerQueue {
    private static final BlockingQueue<Object> queue = new ArrayBlockingQueue<>(20);
    private Integer rejectedRequests = 0;
    private Integer consumedResults = 0;


    public synchronized Boolean addObject(Object object){
         Boolean added = queue.offer(object);
         if(!added) rejectedRequests++;
         notifyAll();
         return added;
    }
    public synchronized Object getObject(){
        while (queue.size()==0){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        consumedResults++;
        return queue.poll();
    }

    public synchronized Statistic getStatistic(){
        Statistic statistic = new Statistic(queue.size(), rejectedRequests, consumedResults);
        rejectedRequests = 0;
        consumedResults = 0;
        return statistic;
    }
}
