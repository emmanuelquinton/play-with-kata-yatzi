package equinton.dev.kata.yatzy.domain.model;

import java.util.Arrays;

public record DiceRoll(int...diceValues) {

    public static DiceRoll of(int...diceValues) {
        return new DiceRoll(diceValues);
    }
    @Override
    public String toString() {
        return "DiceRoll{" +
            "diceValues=" + Arrays.toString(diceValues) +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiceRoll diceRoll = (DiceRoll) o;
        return Arrays.equals(diceValues, diceRoll.diceValues);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(diceValues);
    }
}
