package equinton.dev.kata.yatzy.util;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.model.Score;

import java.util.Arrays;

public  class Game {
    private final Roll roll;
    private final Score expectedResult;


    public Game(Roll roll, Score expectedResult) {
        this.roll = roll;
        this.expectedResult = expectedResult;
    }

    public Roll getRoll() {
        return roll;
    }

    public Score getExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return "Game{" +
            "roll=" + Arrays.toString(roll.dice()) +
            ", expectedResult=" + expectedResult +
            '}';
    }
}