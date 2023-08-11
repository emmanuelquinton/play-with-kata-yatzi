package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SmallStraightRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(DiceRoll.of(new int[]{1,2,3,4,5}), Score.of(15))),
            Arguments.of(new Game(DiceRoll.of(new int[]{2,3,4,5,1}), Score.of(15))),
            Arguments.of(new Game(DiceRoll.of(new int[]{1,2,2,4,5}), Score.of(0)))
        );
    }
}
