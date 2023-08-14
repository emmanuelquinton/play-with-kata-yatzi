package equinton.dev.kata.yatzy.domain.exception;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;
import equinton.dev.kata.yatzy.domain.exeption.NullRollException;
import equinton.dev.kata.yatzy.domain.exeption.YatzyException;

public class NullRollExceptionTest extends AbstractExceptionTest {


    @Override
    protected String getMessage() {
        return  "The roll can't be null to calculate score";
    }

    @Override
    protected String getCode() {
        return "error.yatzy.roll-is-null";
    }

    @Override
    protected YatzyException getYatzyException() {
    return new NullRollException();
    }
}
