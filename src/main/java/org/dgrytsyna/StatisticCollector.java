package org.dgrytsyna;

import java.util.concurrent.Callable;

public class StatisticCollector implements Callable<FinalModelStatistic> {

    private final HandlerQueue queue;

    private Integer queueSize = 0;

    private Integer counter = 30;

    private Double rejectedPercent = 0d;


    public StatisticCollector(HandlerQueue queue) {
        this.queue = queue;
    }

    public FinalModelStatistic call() {
        for (int i=0; i<counter; i++){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Statistic statistic = queue.getStatistic();
            System.out.println("Consumed " +statistic.getConsumedCount() + "  Rejected " +statistic.getRejectedCount() + "  Queue size" + statistic.getSize());
            Double total = (double)statistic.getConsumedCount() + statistic.getRejectedCount();
            rejectedPercent += (double) statistic.getRejectedCount()/total;
            queueSize += statistic.getSize();

        }
        rejectedPercent = rejectedPercent*100/counter;
        FinalModelStatistic finalModelStatistic = new FinalModelStatistic((double)queueSize/counter, rejectedPercent);
        return finalModelStatistic;

    }

}
