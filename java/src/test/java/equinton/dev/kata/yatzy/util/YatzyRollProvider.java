package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class YatzyRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{1,1,1,1,1}, 50)),
            Arguments.of(new Game(new int[]{1,1,1,2,1}, 0)),
            Arguments.of(new Game(new int[]{6,6,6,6,6}, 50)),
            Arguments.of(new Game(new int[]{6,6,6,6,3}, 0))
        );
    }
}
