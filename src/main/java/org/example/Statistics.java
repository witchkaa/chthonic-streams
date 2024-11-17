package org.example;

public class Statistics {
    private final double min;
    private final double max;
    private final double average;
    private final double standardDeviation;

    public Statistics(double min, double max, double average, double standardDeviation) {
        this.min = min;
        this.max = max;
        this.average = average;
        this.standardDeviation = standardDeviation;
    }

    public double getMin() {
        return min;
    }

    public double getMax() {
        return max;
    }

    public double getAverage() {
        return average;
    }

    public double getStandardDeviation() {
        return standardDeviation;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "min=" + min +
                ", max=" + max +
                ", average=" + average +
                ", standardDeviation=" + standardDeviation +
                '}';
    }
}