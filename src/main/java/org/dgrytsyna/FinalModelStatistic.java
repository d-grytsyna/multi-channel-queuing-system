package org.dgrytsyna;

public class FinalModelStatistic {
    private Double avgQueueSize;
    private Double rejectionPercent;

    public FinalModelStatistic(Double avgQueueSize, Double rejectionPercent) {
        this.avgQueueSize = avgQueueSize;
        this.rejectionPercent = rejectionPercent;
    }

    public FinalModelStatistic() {
    }

    @Override
    public String toString() {
        return String.format("FinalModelStatistic{avgQueueSize=%.3f, rejectionPercent=%.3f}", avgQueueSize, rejectionPercent);

    }
}
