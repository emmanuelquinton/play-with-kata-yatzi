package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FullHouseRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{6,2,2,2,6}, 18)),
            Arguments.of(new Game(new int[]{2,3,4,5,6}, 0)),
            Arguments.of(new Game(new int[]{1,1,2,2,2}, 8)),
            Arguments.of(new Game(new int[]{2,2,3,3,4}, 0)),
            Arguments.of(new Game(new int[]{4,4,4,4,4 }, 0))
        );
    }
}
