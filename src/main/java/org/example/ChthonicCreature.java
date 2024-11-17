package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * The ChthonicCreature class represents a mythical creature with attributes such as
 * its name, type, the date of its first mention in literature, and its attack power.
 * It provides methods to retrieve these attributes and calculate the number of years
 * since the creature's first mention.
 */
public class ChthonicCreature {
    String name;
    String type;
    LocalDate firstMentionDate;
    int attackPower;

    /**
     * Constructs a new ChthonicCreature object with the specified attributes.
     *
     * @param name The name of the chthonic creature.
     * @param type The type of the chthonic creature (e.g., Cyclops, Werewolf).
     * @param firstMentionDate The date when the creature was first mentioned in literature.
     * @param attackPower The attack power of the creature, represented as an integer.
     */
    public ChthonicCreature(String name, String type, LocalDate firstMentionDate, int attackPower) {
        this.name = name;
        this.type = type;
        this.firstMentionDate = firstMentionDate;
        this.attackPower = attackPower;
    }

    /**
     * Gets the type of the chthonic creature.
     *
     * @return The type of the creature (e.g., Cyclops, Werewolf).
     */
    public String getType() {
        return type;
    }

    /**
     * Gets the attack power of the chthonic creature.
     *
     * @return The attack power, represented as an integer.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Calculates the number of years since the chthonic creature was first mentioned
     * in literature based on its first mention date.
     *
     * @return The number of years since the first mention of the creature.
     */
    public long getYearsSinceFirstMention() {
        return ChronoUnit.YEARS.between(firstMentionDate, LocalDate.now());
    }

    /**
     * Returns a string representation of the ChthonicCreature object.
     * This includes the name, type, first mention date, and attack power.
     *
     * @return A string representation of the ChthonicCreature object.
     */
    @Override
    public String toString() {
        return String.format("ChthonicCreature{name='%s', type='%s', firstMentionDate=%s, attackPower=%d}",
                name, type, firstMentionDate, attackPower);
    }
}