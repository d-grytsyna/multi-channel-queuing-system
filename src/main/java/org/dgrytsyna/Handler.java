package org.dgrytsyna;


import java.util.Random;

public class Handler extends Thread{
    private final HandlerQueue queue;
    private Random random = new Random();
    public Handler(HandlerQueue queue) {
        this.queue = queue;
    }

    public void run() {
        long startTime = System.currentTimeMillis();
        long endTime = startTime + 60_000;
        while (System.currentTimeMillis() < endTime){
            queue.getObject();
            long sleepDuration = Math.abs(Math.round((random.nextGaussian() * 50) + 400));
            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {}
        }
    }

}
