package equinton.dev.kata.yatzy.util;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.stream.Stream;

public class OnesRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{3,3,3,4,5}, 0)),
            Arguments.of(new Game(new int[]{1,2,3,4,5}, 1)),
            Arguments.of(new Game(new int[]{1,2,1,4,5}, 2)),
            Arguments.of(new Game(new int[]{6,2,2,4,5}, 0)),
            Arguments.of(new Game(new int[]{1,2,1,1,1}, 4))
        );
    }
}
