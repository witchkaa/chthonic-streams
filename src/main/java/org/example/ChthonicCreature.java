package org.example;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ChthonicCreature {
    String name;
    String type;
    LocalDate firstMentionDate;
    int attackPower;

    public ChthonicCreature(String name, String type, LocalDate firstMentionDate, int attackPower) {
        this.name = name;
        this.type = type;
        this.firstMentionDate = firstMentionDate;
        this.attackPower = attackPower;
    }

    public String getType() {
        return type;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public long getYearsSinceFirstMention() {
        return ChronoUnit.YEARS.between(firstMentionDate, LocalDate.now());
    }

    @Override
    public String toString() {
        return String.format("ChthonicCreature{name='%s', type='%s', firstMentionDate=%s, attackPower=%d}",
                name, type, firstMentionDate, attackPower);
    }
}