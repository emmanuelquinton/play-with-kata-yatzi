package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class YatzyRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(DiceRoll.of(new int[]{1,1,1,1,1}), Score.of(50))),
            Arguments.of(new Game(DiceRoll.of(new int[]{1,1,1,2,1}), Score.of(0))),
            Arguments.of(new Game(DiceRoll.of(new int[]{6,6,6,6,6}), Score.of(50))),
            Arguments.of(new Game(DiceRoll.of(new int[]{6,6,6,6,3}), Score.of(0)))
        );
    }
}
