package equinton.dev.kata.yatzy.domain;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.exeption.NullCategoryException;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

  @Test
  void should_thrown_an_exception_when_categoy_is_null() {
      // given

      // when
      AbstractThrowableAssert<?, ? extends Throwable> actualThrowableAssert = Assertions.assertThatThrownBy(() -> new CalculateYatzyScoreUseCase().execute(null, Roll.of(new int[]{1, 2, 3, 4, 5})));

      // then
      actualThrowableAssert.as("Check that an exception is thrown when the catagory is null")
          .isInstanceOf(NullCategoryException.class)
          .hasMessage("The category can't be null to calculate score.")
          .hasFieldOrPropertyWithValue("code", "error.yatzy.category-is-null");
  }
}
