package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TreeOfKindRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,3,4,5}), Score.of(9))),
            Arguments.of(new Game(DiceRoll.of(new int[]{5,3,5,4,5}), Score.of(15))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,3,3,5}), Score.of(9))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,4,5,6 }), Score.of(0))),
            Arguments.of(new Game(DiceRoll.of(new int[]{3,3,3,3,1 }), Score.of(9)))
        );
    }
}
