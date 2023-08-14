package equinton.dev.kata.yatzy.util;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public  class ChanceRollProvider implements ArgumentsProvider{
    public ChanceRollProvider() {
    }

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(Roll.of(new int[]{1,1,3,3,6}), Score.of(14))),
            Arguments.of(new Game(Roll.of(new int[]{4,5,5,6,1}), Score.of(21))),
            Arguments.of(new Game(Roll.of(new int[]{2,3,4,5,1}), Score.of(15))),
            Arguments.of(new Game(Roll.of(new int[]{3,3,4,5,1}), Score.of(16)))
        );
    }
}

