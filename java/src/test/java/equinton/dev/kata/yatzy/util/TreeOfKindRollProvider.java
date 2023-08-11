package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TreeOfKindRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(new int[]{3,3,3,4,5}, 9)),
            Arguments.of(new Game(new int[]{5,3,5,4,5}, 15)),
            Arguments.of(new Game(new int[]{3,3,3,3,5}, 9)),
            Arguments.of(new Game(new int[]{3,3,4,5,6 }, 0)),
            Arguments.of(new Game(new int[]{3,3,3,3,1 }, 9))
        );
    }
}
