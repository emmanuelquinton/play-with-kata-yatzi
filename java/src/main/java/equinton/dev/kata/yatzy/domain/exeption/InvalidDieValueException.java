package equinton.dev.kata.yatzy.domain.exeption;

public class InvalidDieValueException extends YatzyException {

    public InvalidDieValueException() {
        super("error.yatzy.die-value", "The value of a die must be between 1 and 6.");
    }
}
