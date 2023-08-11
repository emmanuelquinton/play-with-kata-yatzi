package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class FoursRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{4,4,4,5,5}, 12)),
            Arguments.of(new Game(new int[]{4,4,5,5,5}, 8)),
            Arguments.of(new Game(new int[]{4,5,5,5,5}, 4))
        );
    }
}
