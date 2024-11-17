package org.example;

import java.util.stream.Collector;

public class StatisticsCollector {
    public static Collector<Integer, ?, Statistics> toStatistics() {
        return Collector.of(
                StatisticsContainer::new,
                StatisticsContainer::accept,
                StatisticsContainer::combine,
                StatisticsContainer::toStatistics
        );
    }
}

class StatisticsContainer {
    private int count = 0;
    private double sum = 0;
    private double sumOfSquares = 0;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public void accept(int value) {
        count++;
        sum += value;
        sumOfSquares += value * value;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    public StatisticsContainer combine(StatisticsContainer other) {
        count += other.count;
        sum += other.sum;
        sumOfSquares += other.sumOfSquares;
        min = Math.min(min, other.min);
        max = Math.max(max, other.max);
        return this;
    }

    public Statistics toStatistics() {
        double average = count == 0 ? 0 : sum / count;
        double variance = count == 0 ? 0 : (sumOfSquares / count) - (average * average);
        double standardDeviation = Math.sqrt(variance);
        return new Statistics(min, max, average, standardDeviation);
    }
}