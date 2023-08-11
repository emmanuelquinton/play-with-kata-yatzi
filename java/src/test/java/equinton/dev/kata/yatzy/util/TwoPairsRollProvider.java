package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TwoPairsRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{1,1,2,3,3 }, 8)),
            Arguments.of(new Game(new int[]{1,1,2,3,4}, 0)),
            Arguments.of(new Game(new int[]{1,1,2,2,2}, 6)),
            Arguments.of(new Game(new int[]{3,3,3,3,1}, 0)),
            Arguments.of(new Game(new int[]{3,3,5,4,5}, 16)),
            Arguments.of(new Game(new int[]{3,3,5,5,5}, 16))

        );
    }
}
