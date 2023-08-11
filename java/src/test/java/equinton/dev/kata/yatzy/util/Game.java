package equinton.dev.kata.yatzy.util;

import java.util.Arrays;

public  class Game {
    private final int[] roll;
    private final int expectedResult;


    public Game(int[] roll, int expectedResult) {
        this.roll = roll;
        this.expectedResult = expectedResult;
    }

    public int[] getRoll() {
        return roll;
    }

    public int getExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return "Game{" +
            "roll=" + Arrays.toString(roll) +
            ", expectedResult=" + expectedResult +
            '}';
    }
}