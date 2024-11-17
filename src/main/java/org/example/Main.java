package org.example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int N = 100;
        int minYears = 100;
        int maxYears = 1500;
        List<ChtonicCreature> filteredCreatures = Gatherer.infiniteCreatureStream()
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

        Map<String, List<ChtonicCreature>> groupedByType = filteredCreatures.stream()
                .collect(Collectors.groupingBy(ChtonicCreature::getType));

        System.out.println("\nGrouped by Type:");
        groupedByType.forEach((type, creatures) -> System.out.println(type + ": " + creatures.size()));

        Map<String, Long> attackPowerAnalysis = Gatherer.analyzeCreatures(filteredCreatures);

        System.out.println("\nAttack Power Analysis: " + attackPowerAnalysis);
    }
}