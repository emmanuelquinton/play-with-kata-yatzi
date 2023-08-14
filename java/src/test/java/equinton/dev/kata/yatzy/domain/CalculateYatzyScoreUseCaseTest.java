package equinton.dev.kata.yatzy.domain;

import equinton.dev.kata.yatzy.domain.exeption.NullCategoryException;
import equinton.dev.kata.yatzy.domain.exeption.NullRollException;
import equinton.dev.kata.yatzy.domain.model.Category;
import equinton.dev.kata.yatzy.domain.model.Roll;
import equinton.dev.kata.yatzy.util.*;
import org.assertj.core.api.AbstractThrowableAssert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

class CalculateYatzyScoreUseCaseTest {


    @Test
    void should_thrown_an_exception_when_categoy_is_null() {
        // given

        // when
        AbstractThrowableAssert<?, ? extends Throwable> actualThrowableAssert = Assertions.assertThatThrownBy(() -> new CalculateYatzyScoreUseCase().execute(null, Roll.of(new int[]{1, 2, 3, 4, 5})));

        // then
        actualThrowableAssert.as("Check that an exception is thrown when the catagory is null")
            .isInstanceOf(NullCategoryException.class)
            .hasMessage("The category can't be null to calculate score.")
            .hasFieldOrPropertyWithValue("code", "error.yatzy.category-is-null");
    }

    @Test
    void should_thrown_an_exception_when_dice_roll_is_null() {
        // given

        // when
        AbstractThrowableAssert<?, ? extends Throwable> actualThrowableAssert = Assertions.assertThatThrownBy(() -> new CalculateYatzyScoreUseCase().execute(Category.CHANCE, null));

    // then
    actualThrowableAssert
        .as("Check that an exception is thrown when the catagory is null")
        .isInstanceOf(NullRollException.class)
        .hasMessage("The roll can't be null to calculate score")
        .hasFieldOrPropertyWithValue("code", "error.yatzy.roll-is-null");
    }
    @ParameterizedTest
    @ArgumentsSource(ChanceRollProvider.class)
    void should_calculate_chance_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

    // when
    var actualScore = calculateYatzyScoreUseCase.execute(Category.CHANCE, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'chance' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(OnesRollProvider.class)
    void should_calculate_onces_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.ONES, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'onces' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(TwosRollProvider.class)
    void should_calculate_twos_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.TWOS, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'twos' score is correct")
            .isEqualTo(game.getExpectedResult());
    }


    @ParameterizedTest
    @ArgumentsSource(TreesRollProvider.class)
    void should_calculate_trees_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.TREES, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'trees' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(FoursRollProvider.class)
    void should_calculate_fours_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.FOURS, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'fours' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(FivesRollProvider.class)
    void should_calculate_fives_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.FIVES, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'fives' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(SixRollProvider.class)
    void should_calculate_sixes_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.SIXES, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'sixes' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(PairRollProvider.class)
    void should_calculate_pair_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.PAIR, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'pair' score is correct")
            .isEqualTo(game.getExpectedResult());
    }


    @ParameterizedTest
    @ArgumentsSource(TwoPairsRollProvider.class)
    void should_calculate_two_pairs_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.TWO_PAIRS, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'two pair' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(TreeOfKindRollProvider.class)
    void should_calculate_tree_of_kinds_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.TREE_OF_KIND, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'tree of kind' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(FourOfKinfRollProvider.class)
    void should_calculate_four_of_kind_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.FOUR_OF_KIND, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'four of kind' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(SmallStraightRollProvider.class)
    void should_calculate_small_straight_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.SMALL_STRAIGHT, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'small straight' score is correct")
            .isEqualTo(game.getExpectedResult());
    }


    @ParameterizedTest
    @ArgumentsSource(LargeStraightRollProvider.class)
    void should_calculate_large_straight_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.LARGE_STRAIGHT, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'large straight' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(FullHouseRollProvider.class)
    void should_calculate_full_house_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.FULL_HOUSE, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'full house' score is correct")
            .isEqualTo(game.getExpectedResult());
    }

    @ParameterizedTest
    @ArgumentsSource(YatzyRollProvider.class)
    void should_calculate_yatzy_score(Game game){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.YATZY, game.getRoll());

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the 'yatzy' score is correct")
            .isEqualTo(game.getExpectedResult());
    }
}
