package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.exeption.InvalidDieValueException;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4,5,6})
    void should_die_has_only_six_faces(int dieFaceValue){
        // when
        var actualDie = Die.of(dieFaceValue);

        // then
        Assertions.assertThat(actualDie)
            .as("Check that the die has been created")
            .isNotNull()
            .hasFieldOrPropertyWithValue("value", dieFaceValue);

    }

    @ParameterizedTest
    @ValueSource(ints = {0,7,-1})
    void should_die_instantiation_throws_an_excpetion_when_its_value_is_invalid(int dieFaceValue){
        // when
        AbstractThrowableAssert<?, ? extends Throwable> actualThrowableAssert = Assertions.assertThatThrownBy(() -> Die.of(dieFaceValue));

        // then
        actualThrowableAssert
            .as("Check that an exception is thorwn when the die value is invalid.")
            .isInstanceOf(InvalidDieValueException.class)
            .hasMessage( "The value of a die must be between 1 and 6.");

    }

        }
