package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.model.Category;
import equinton.dev.kata.yatzy.domain.model.ScoreCalculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

class CategoryScoreCalulatorTest {

  @ParameterizedTest
  @ArgumentsSource(CalculatorByCategoryExemplesProvider.class)
  void should_get_calculator_by_categegory(Category category, ScoreCalculator expectedScoreCalculator) {

    // given

    // when
    ScoreCalculator actualCalculator = ScoreCalculator.getByCategory(category);

    // then
    Assertions.assertThat(actualCalculator)
        .as("Check the calculator has been returned")
        .isNotNull()
        .isEqualTo(expectedScoreCalculator);
  }

    private static class CalculatorByCategoryExemplesProvider implements ArgumentsProvider {
        public CalculatorByCategoryExemplesProvider() {
        }

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                Arguments.of(Category.CHANCE, ScoreCalculator.CHANCE_CALCULATOR),
                Arguments.of(Category.ONES, ScoreCalculator.ONES_CALCULATOR),
                Arguments.of(Category.TWOS, ScoreCalculator.TWO_CALCULATOR),
                Arguments.of(Category.TREES, ScoreCalculator.TREES_CALCULATOR),
                Arguments.of(Category.FOURS, ScoreCalculator.FOURS_CALCULATOR),
                Arguments.of(Category.FIVES, ScoreCalculator.FIVES_CALCULATOR),
                Arguments.of(Category.SIXES, ScoreCalculator.SIXES_CALCULATOR),
                Arguments.of(Category.PAIR, ScoreCalculator.PAIR_CALCULATOR),
                Arguments.of(Category.TWO_PAIRS, ScoreCalculator.TWO_PAIRS_CALCULATOR),
                Arguments.of(Category.TREE_OF_KIND, ScoreCalculator.TREE_OF_KIND_CALCULATOR),
                Arguments.of(Category.FOUR_OF_KIND, ScoreCalculator.FOUR_OF_KIND_CALCULATOR),
                Arguments.of(Category.SMALL_STRAIGHT, ScoreCalculator.SMALL_STRAIGHT_CALCULATOR),
                Arguments.of(Category.LARGE_STRAIGHT, ScoreCalculator.LARGE_STRAIGHT_CALCULATOR),
                Arguments.of(Category.FULL_HOUSE, ScoreCalculator.FULL_HOUSE_CALCULATOR),
                Arguments.of(Category.YATZY, ScoreCalculator.YATZY_CALCULATOR)

            );
        }
    }
}
