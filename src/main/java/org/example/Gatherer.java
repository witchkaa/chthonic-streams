package org.example;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gatherer {
    private static final List<String> NAMES = Arrays.asList("Polyphemos", "Derek", "Medusa", "Dracula", "Lamia", "Mavka");
    private static final List<String> TYPES = Arrays.asList("Cyclops", "Werewolf", "Gorgon", "Vampire", "Witch", "Mermaid");
    private static final Random RANDOM = new Random();

    private static ChthonicCreature generateCreature() {
        String name = NAMES.get(RANDOM.nextInt(NAMES.size()));
        String type = TYPES.get(RANDOM.nextInt(TYPES.size()));
        LocalDate firstMentionDate = LocalDate.now().minusYears(RANDOM.nextInt(2000));
        int attackPower = RANDOM.nextInt(100);
        return new ChthonicCreature(name, type, firstMentionDate, attackPower);
    }

    public static Stream<ChthonicCreature> infiniteCreatureStream() {
        return Stream.generate(Gatherer::generateCreature);
    }

    public static Map<String, Long> analyzeCreatures(List<ChthonicCreature> creatures) {
        List<Integer> attackPowers = creatures.stream()
                .map(ChthonicCreature::getAttackPower)
                .sorted()
                .collect(Collectors.toList());


        if (attackPowers.size() < 4) {
            return Map.of("data", 0L, "outliers", (long) attackPowers.size());
        }


        int q1 = attackPowers.get(attackPowers.size() / 4);
        int q3 = attackPowers.get(2 * attackPowers.size() / 4);
        int iqr = q3 - q1;


        int lowerBound = q1 - iqr;
        int upperBound = q3 + iqr;


        return creatures.stream()
                .collect(Collectors.partitioningBy(
                        c -> c.getAttackPower() < lowerBound || c.getAttackPower() > upperBound,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        e -> e.getKey() ? "outliers" : "data", // Заміна ключів
                        Map.Entry::getValue
                ));
    }

}