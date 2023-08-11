package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class PairRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{1,2,3,4,5}, 0)),
            Arguments.of(new Game(new int[]{3,3,3,4,4}, 8)),
            Arguments.of(new Game(new int[]{1,1,6,2,6}, 12)),
            Arguments.of(new Game(new int[]{3,3,3,4,1}, 6)),
            Arguments.of(new Game(new int[]{3,3,3,3,1}, 6)),
            Arguments.of(new Game(new int[]{3,4,3,5,6}, 6)),
            Arguments.of(new Game(new int[]{5,3,3,3,5}, 10)),
            Arguments.of(new Game(new int[]{5,3,6,6,5}, 12))
        );
    }
}
