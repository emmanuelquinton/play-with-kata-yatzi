package equinton.dev.kata.yatzy.domain.exeption;

public class NullRollException extends YatzyException {
  public NullRollException() {
    super("error.yatzy.roll-is-null", "The roll can't be null to calculate score");
  }
}
