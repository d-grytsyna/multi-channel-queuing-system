package org.dgrytsyna;

import java.util.Random;

public class RequestProducer extends Thread{
    private final HandlerQueue queue;
    private  Random random = new Random();
    public RequestProducer(HandlerQueue queue) {
        this.queue = queue;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60_000;
        while (System.currentTimeMillis() < endTime){
            queue.addObject(new Object());
            int sleepDuration = random.nextInt(100 - 50 + 1) + 50;
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {}
        }
    }

}
