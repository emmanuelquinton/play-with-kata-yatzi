package equinton.dev.kata.yatzy.domain.exception;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;
import equinton.dev.kata.yatzy.domain.exeption.NullCategoryException;
import equinton.dev.kata.yatzy.domain.exeption.YatzyException;

public class NullCategoryExceptionTest extends AbstractExceptionTest {


    @Override
    protected String getMessage() {
        return "The category can't be null to calculate score.";
    }

    @Override
    protected String getCode() {
        return "error.yatzy.category-is-null";
    }

    @Override
    protected YatzyException getYatzyException() {
    return new NullCategoryException();
    }
}
