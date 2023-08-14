package equinton.dev.kata.yatzy.domain.exeption;

public class NumberDiceRollException extends YatzyException {

  public NumberDiceRollException() {
    super("error.yatzy.roll.number-dice-invalid", "A Yatzy roll must contains 5 dice");
  }
}
