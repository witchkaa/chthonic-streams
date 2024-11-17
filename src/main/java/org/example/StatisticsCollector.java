package org.example;

import java.util.stream.Collector;

/**
 * The StatisticsCollector class provides a custom collector
 * for computing statistics from a stream of numeric values.
 */
public class StatisticsCollector {

    /**
     * Creates a Collector that calculates statistical values
     * (min, max, average, and standard deviation) from a stream of integers.
     *
     * @return A custom Collector for statistics
     */
    public static Collector<Integer, ?, Statistics> toStatistics() {
        return Collector.of(
                StatisticsContainer::new,
                StatisticsContainer::accept,
                StatisticsContainer::combine,
                StatisticsContainer::toStatistics
        );
    }
}

/**
 * The StatisticsContainer class is an intermediate container
 * used during the collection process to calculate statistical values.
 */
class StatisticsContainer {
    private int count = 0;
    private double sum = 0;
    private double sumOfSquares = 0;
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    /**
     * Accepts a value and updates the container's state.
     *
     * @param value The value to add to the statistics
     */
    public void accept(int value) {
        count++;
        sum += value;
        sumOfSquares += value * value;
        min = Math.min(min, value);
        max = Math.max(max, value);
    }

    /**
     * Combines another StatisticsContainer into this one.
     * Used for parallel streams to merge partial results.
     *
     * @param other Another StatisticsContainer to combine with this one
     * @return The combined StatisticsContainer
     */
    public StatisticsContainer combine(StatisticsContainer other) {
        count += other.count;
        sum += other.sum;
        sumOfSquares += other.sumOfSquares;
        min = Math.min(min, other.min);
        max = Math.max(max, other.max);
        return this;
    }

    /**
     * Converts the container's state into a Statistics object.
     *
     * @return A Statistics object with the computed values
     */
    public Statistics toStatistics() {
        double average = count == 0 ? 0 : sum / count;
        double variance = count == 0 ? 0 : (sumOfSquares / count) - (average * average);
        double standardDeviation = Math.sqrt(variance);
        return new Statistics(min, max, average, standardDeviation);
    }
}