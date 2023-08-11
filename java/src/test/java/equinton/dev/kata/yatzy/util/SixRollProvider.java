package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SixRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{4,4,4,5,5}, 0)),
            Arguments.of(new Game(new int[]{4,4,6,5,5}, 6)),
            Arguments.of(new Game(new int[]{6,5,6,6,5}, 18))
        );
    }
}
