package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TwoPairsRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(DiceRoll.of(new int[]{1,1,2,3,3 }), Score.of(8))),
            Arguments.of(new Game(DiceRoll.of(new int[]{1,1,2,3,4}), Score.of(0))),
            Arguments.of(new Game(DiceRoll.of(new int[]{1,1,2,2,2}), Score.of(6))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,3,3,1}), Score.of(0))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,5,4,5}), Score.of(16))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,5,5,5}), Score.of(16)))
        );
    }
}
