package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int N = 100;
        int minYears = 100;
        int maxYears = 1500;

        List<ChthonicCreature> filteredCreatures = Gatherer.infiniteCreatureStream()
                .skip(N)
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