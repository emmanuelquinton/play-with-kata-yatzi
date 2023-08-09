package equinton.dev.kata.yatzy.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculateYatzyScoreTest {


    @Test
    void should_caalculate_chance_score(){
        // given
        var calculateYatzyScoreUseCase = new CalculateYatzyScoreUseCase();
        int[] diceValues = {1,1,3,3,6};

        // when
        var actualScore = calculateYatzyScoreUseCase.execute(Category.CHANCE, diceValues);

        // then

        Assertions.assertThat(actualScore)
            .as("Check that the score is correct")
            .isEqualTo(14);
    }
}
