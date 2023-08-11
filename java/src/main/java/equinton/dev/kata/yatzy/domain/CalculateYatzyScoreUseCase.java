package equinton.dev.kata.yatzy.domain;

import static equinton.dev.kata.yatzy.domain.YatzyUtils.*;

import java.util.Map;
import java.util.function.Predicate;

public class CalculateYatzyScoreUseCase {
  public int execute(Category category, int[] diceRoll) {
      return ScoreCalculator.getByCategory(category).calculate(diceRoll);
  }
}
