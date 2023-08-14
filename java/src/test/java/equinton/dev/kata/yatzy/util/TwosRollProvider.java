package equinton.dev.kata.yatzy.util;

import java.util.stream.Stream;

import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.domain.model.Score;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class TwosRollProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
            Arguments.of(new Game(Roll.of(new int[]{1,2,3,2,6}), Score.of(4))),
            Arguments.of(new Game(Roll.of(new int[]{2,2,2,2,2}), Score.of(10)))
        );
    }
}
