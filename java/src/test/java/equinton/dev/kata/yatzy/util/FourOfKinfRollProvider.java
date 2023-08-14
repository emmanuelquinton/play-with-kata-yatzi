package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FourOfKinfRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(Roll.of(new int[]{2,2,2,2,5}), Score.of(8))),
            Arguments.of(new Game(Roll.of(new int[]{2,2,2,5,5}), Score.zero())),
            Arguments.of(new Game(Roll.of(new int[]{2,2,2,2,2}), Score.of(8))),
            Arguments.of(new Game(Roll.of(new int[]{3,3,3,3,5}), Score.of(12))),
            Arguments.of(new Game(Roll.of(new int[]{5,5,5,4,5}), Score.of(20))),
            Arguments.of(new Game(Roll.of(new int[]{3,3,3,3,3}), Score.of(12)))
        );
    }
}
