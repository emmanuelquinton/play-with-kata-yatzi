package equinton.dev.kata.yatzy.domain;

import equinton.dev.kata.yatzy.domain.exeption.NullRollException;
import equinton.dev.kata.yatzy.domain.model.*;
import equinton.dev.kata.yatzy.domain.exeption.NullCategoryException;

public class CalculateYatzyScoreUseCase {
  public Score execute(Category category, Roll diceRoll) {
      if(new CategoryNotNullSpecification().isNotSatifiedBy(category)) {
          throw new NullCategoryException();
      }
      if(new RollNotNullSpecification().isNotSatifiedBy(diceRoll)) {
      throw new NullRollException();
      }
      return ScoreCalculator.getByCategory(category).calculate(diceRoll);
  }
}
