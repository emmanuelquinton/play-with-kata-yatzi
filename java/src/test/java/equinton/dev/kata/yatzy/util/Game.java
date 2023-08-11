package equinton.dev.kata.yatzy.util;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;

import java.util.Arrays;

public  class Game {
    private final DiceRoll roll;
    private final Score expectedResult;


    public Game(DiceRoll roll, Score expectedResult) {
        this.roll = roll;
        this.expectedResult = expectedResult;
    }

    public DiceRoll getRoll() {
        return roll;
    }

    public Score getExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return "Game{" +
            "roll=" + Arrays.toString(roll.diceValues()) +
            ", expectedResult=" + expectedResult +
            '}';
    }
}