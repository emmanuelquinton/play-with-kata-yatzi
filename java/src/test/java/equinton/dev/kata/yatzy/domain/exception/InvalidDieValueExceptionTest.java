package equinton.dev.kata.yatzy.domain.exception;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;
import equinton.dev.kata.yatzy.domain.exeption.YatzyException;

public class InvalidDieValueExceptionTest extends AbstractExceptionTest {


    @Override
    protected String getMessage() {
        return "The value of a die must be between 1 and 6.";
    }

    @Override
    protected String getCode() {
        return "error.yatzy.die-value";
    }

    @Override
    protected YatzyException getYatzyException() {
        return new InvalidDieValueException();
    }
}
