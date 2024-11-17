package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The Main class serves as the entry point for the program.
 * It filters a list of chthonic creatures based on certain criteria,
 * groups them by type, and performs an analysis of attack powers.
 * The filtered and grouped creatures are printed, followed by an analysis of attack power.
 */
public class Main {

    /**
     * The main method is the entry point of the program.
     * It initializes a list of creatures, filters them, groups them by type,
     * and performs an attack power analysis.
     *
     * @param args Command-line arguments (not used in this case)
     */
    public static void main(String[] args) {
        int n = 100;
        int minYears = 100;
        int maxYears = 1500;

        List<ChthonicCreature> filteredCreatures = Gatherer.infiniteCreatureStream()
                .skip(n)
                .filter(c -> !c.getType().equals("Witch"))
                .filter(c -> {
                    long years = c.getYearsSinceFirstMention();
                    return years >= minYears && years <= maxYears;
                })
                .limit(500)
                .collect(Collectors.toList());

        System.out.println("Filtered Creatures:");
        filteredCreatures.forEach(System.out::println);

        Map<String, List<ChthonicCreature>> groupedByType = filteredCreatures.stream()
                .collect(Collectors.groupingBy(ChthonicCreature::getType));

        System.out.println("\nGrouped by Type:");
        groupedByType.forEach((type, creatures) -> System.out.println(type + ": " + creatures.size()));

        Statistics attackPowerStats = filteredCreatures.stream()
                .map(ChthonicCreature::getAttackPower)
                .collect(StatisticsCollector.toStatistics());

        System.out.println("\nAttack Power Statistics:");
        System.out.println("Min: " + attackPowerStats.getMin());
        System.out.println("Max: " + attackPowerStats.getMax());
        System.out.println("Average: " + attackPowerStats.getAverage());
        System.out.println("Standard Deviation: " + attackPowerStats.getStandardDeviation());

        Map<String, Long> attackPowerAnalysis = Gatherer.analyzeCreatures(filteredCreatures);

        System.out.println("\nAttack Power Analysis: " + attackPowerAnalysis);
    }
}