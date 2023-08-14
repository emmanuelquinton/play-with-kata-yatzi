package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.exeption.NumberDiceRollException;
import java.util.Arrays;

public record Roll(Die... dice) {
  public Roll {
    if (dice.length != 5) {
      throw new NumberDiceRollException();
    }
  }

    public static Roll of(int...diceValues) {
        var dice = Arrays.stream(diceValues).mapToObj(Die::of).toArray(Die[]::new);
        return new Roll(dice);
    }
  public static Roll of(Die...dice) {
    return new Roll(dice);
  }

  @Override
  public String toString() {
    return "Roll{" + "diceValues=" + Arrays.toString(dice) + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Roll roll = (Roll) o;
    return Arrays.equals(dice, roll.dice);
  }

  @Override
  public int hashCode() {
    return Arrays.hashCode(dice);
  }
}
