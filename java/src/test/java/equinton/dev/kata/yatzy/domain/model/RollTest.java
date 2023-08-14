package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.exeption.NumberDiceRollException;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class RollTest {

    @Test

    void should_roll_throws_runtimeExeption_when_dice_number_not_equles_5() {
        // given

        // when
        AbstractThrowableAssert<?, ? extends Throwable> actualRollAssertions = Assertions.assertThatThrownBy(() -> Roll.of(1, 2, 3, 4));

        // then
        actualRollAssertions.as("Check that an ecption is thrown when roll not contains exactly 5 dice")
            .isInstanceOf(NumberDiceRollException.class)
            .hasMessage("A Yatzy roll must contains 5 dice")
            .hasFieldOrPropertyWithValue("code", "error.yatzy.roll.number-dice-invalid");
    }

}
