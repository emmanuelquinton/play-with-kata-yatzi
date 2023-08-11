package equinton.dev.kata.yatzy.domain.model;

public record Score(int value) {

    public static Score of(int value) {
        return new Score(value);
    }

    public static Score zero() {
        return new Score(0);
    }
}
