package org.example;

/**
 * The Statistics class is used to store statistical data,
 * such as minimum, maximum, average, and standard deviation.
 */

public class Statistics {
    private final double min; // Minimum value
    private final double max; // Maximum value
    private final double average; // Average value
    private final double standardDeviation; // Standard deviation

    /**
     * Constructor to create a Statistics object.
     *
     * @param min               Minimum value
     * @param max               Maximum value
     * @param average           Average value
     * @param standardDeviation Standard deviation
     */
    public Statistics(double min, double max, double average, double standardDeviation) {
        this.min = min;
        this.max = max;
        this.average = average;
        this.standardDeviation = standardDeviation;
    }

    /**
     * Returns the minimum value.
     *
     * @return Minimum value
     */
    public double getMin() {
        return min;
    }

    /**
     * Returns the maximum value.
     *
     * @return Maximum value
     */
    public double getMax() {
        return max;
    }

    /**
     * Returns the average value.
     *
     * @return Average value
     */
    public double getAverage() {
        return average;
    }

    /**
     * Returns the standard deviation.
     *
     * @return Standard deviation
     */
    public double getStandardDeviation() {
        return standardDeviation;
    }

    /**
     * Returns a string representation of the Statistics object.
     *
     * @return String representation
     */
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