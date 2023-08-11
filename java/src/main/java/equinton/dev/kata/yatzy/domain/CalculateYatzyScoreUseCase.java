package equinton.dev.kata.yatzy.domain;

import equinton.dev.kata.yatzy.domain.model.DiceRoll;
import equinton.dev.kata.yatzy.domain.model.Score;

public class CalculateYatzyScoreUseCase {
  public Score execute(Category category, DiceRoll diceRoll) {
      return ScoreCalculator.getByCategory(category).calculate(diceRoll);
  }
}
