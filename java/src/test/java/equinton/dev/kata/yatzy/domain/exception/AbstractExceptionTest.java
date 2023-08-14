package equinton.dev.kata.yatzy.domain.exception;

import equinton.dev.kata.yatzy.domain.exeption.YatzyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public abstract class AbstractExceptionTest {
  private YatzyException yatzyException = getYatzyException();

  @Test
  void should_code_exception_is_correct() {

    Assertions.assertThat(yatzyException)
        .as("Check that the exception has a correct code")
        .hasFieldOrPropertyWithValue("code", getCode());
  }

  @Test
  void should_message_exception_is_correct() {

    Assertions.assertThat(yatzyException)
        .as("Check that the exception has a correct code")
        .hasFieldOrPropertyWithValue("message", getMessage());
  }

  protected abstract String getMessage();

  protected abstract String getCode();

  protected abstract YatzyException getYatzyException();
}
