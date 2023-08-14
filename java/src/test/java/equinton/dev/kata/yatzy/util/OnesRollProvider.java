package equinton.dev.kata.yatzy.util;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class OnesRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(Roll.of(new int[]{3,3,3,4,5}), Score.zero())),
            Arguments.of(new Game(Roll.of(new int[]{1,2,3,4,5}), Score.of(1))),
            Arguments.of(new Game(Roll.of(new int[]{1,2,1,4,5}), Score.of(2))),
            Arguments.of(new Game(Roll.of(new int[]{6,2,2,4,5}), Score.zero())),
            Arguments.of(new Game(Roll.of(new int[]{1,2,1,1,1}), Score.of(4)))

        );
    }
}
