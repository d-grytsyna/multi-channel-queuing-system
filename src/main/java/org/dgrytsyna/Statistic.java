package org.dgrytsyna;

public class Statistic {
    private Integer size;
    private Integer rejectedCount;

    private Integer consumedCount;

    public Statistic(Integer size, Integer rejectedCount, Integer consumedCount) {
        this.size = size;
        this.rejectedCount = rejectedCount;
        this.consumedCount = consumedCount;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getRejectedCount() {
        return rejectedCount;
    }

    public Integer getConsumedCount() {
        return consumedCount;
    }
}
