package equinton.dev.kata.yatzy.domain.exception;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;
import equinton.dev.kata.yatzy.domain.exeption.NumberDiceRollException;
import equinton.dev.kata.yatzy.domain.exeption.YatzyException;

public class NumberDiceRollExceptionTest extends AbstractExceptionTest {


    @Override
    protected String getMessage() {
        return "A Yatzy roll must contains 5 dice";
    }

    @Override
    protected String getCode() {
        return "error.yatzy.roll.number-dice-invalid";
    }

    @Override
    protected YatzyException getYatzyException() {
    return new NumberDiceRollException();
    }
}
