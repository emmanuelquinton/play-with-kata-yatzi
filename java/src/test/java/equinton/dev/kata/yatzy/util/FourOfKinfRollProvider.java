package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FourOfKinfRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{2,2,2,2,5}, 8)),
            Arguments.of(new Game(new int[]{2,2,2,5,5}, 0)),
            Arguments.of(new Game(new int[]{2,2,2,2,2}, 8)),
            Arguments.of(new Game(new int[]{3,3,3,3,5}, 12)),
            Arguments.of(new Game(new int[]{5,5,5,4,5}, 20)),
            Arguments.of(new Game(new int[]{3,3,3,3,3}, 12))
        );
    }
}
