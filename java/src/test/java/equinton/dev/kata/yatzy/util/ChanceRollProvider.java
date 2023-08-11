package equinton.dev.kata.yatzy.util;

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
            Arguments.of(new Game(new int[]{1,1,3,3,6}, 14)),
            Arguments.of(new Game(new int[]{4,5,5,6,1}, 21)),
            Arguments.of(new Game(new int[]{2,3,4,5,1}, 15)),
            Arguments.of(new Game(new int[]{3,3,4,5,1}, 16))
        );
    }
}

