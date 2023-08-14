package equinton.dev.kata.yatzy;

import equinton.dev.kata.yatzy.domain.CalculateYatzyScoreUseCase;
import equinton.dev.kata.yatzy.domain.model.Category;
import equinton.dev.kata.yatzy.domain.model.Roll;

public class Yatzy {

  protected int[] dice;

  public Yatzy(int... dices) {
    this.dice = dices;
  }
  public static int chance(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.CHANCE, Roll.of(dices)).value();
  }

  public static int ones(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.ONES, Roll.of(dices)).value();
  }

  public static int twos(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TWOS, Roll.of(dices)).value();
  }

  public static int threes(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TREES, Roll.of(dices)).value();
  }


  public int fours() {
    return new CalculateYatzyScoreUseCase().execute(Category.FOURS, Roll.of(this.dice)).value();
  }

  public int fives() {
    return new CalculateYatzyScoreUseCase().execute(Category.FIVES, Roll.of(this.dice)).value();
  }

  public int sixes() {
    return new CalculateYatzyScoreUseCase().execute(Category.SIXES, Roll.of(this.dice)).value();
  }

  public static int score_pair(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.PAIR, Roll.of(dices)).value();
  }

  public static int two_pair(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TWO_PAIRS, Roll.of(dices)).value();
  }

  public static int three_of_a_kind(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TREE_OF_KIND, Roll.of(dices)).value();
  }

  public static int four_of_a_kind(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.FOUR_OF_KIND, Roll.of(dices)).value();
  }

  public static int smallStraight(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.SMALL_STRAIGHT, Roll.of(dices)).value();
  }

  public static int largeStraight(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.LARGE_STRAIGHT, Roll.of(dices)).value();
  }

  public static int fullHouse(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.FULL_HOUSE, Roll.of(dices)).value();
  }

  public static int yatzy(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.YATZY, Roll.of(dices)).value();
  }
}
