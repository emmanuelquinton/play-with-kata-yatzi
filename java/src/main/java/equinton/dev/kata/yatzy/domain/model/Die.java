package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;

public record Die(int value) {
  public Die {
    if (value < 1 || value > 6) {
      throw new InvalidDieValueException();
    }
  }

  public static Die of(int dieFaceValue) {
    return new Die(dieFaceValue);
  }
}
