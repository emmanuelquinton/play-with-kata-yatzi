package equinton.dev.kata.yatzy;

import static equinton.dev.kata.yatzy.domain.YatzyUtils.*;

import equinton.dev.kata.yatzy.domain.CalculateYatzyScoreUseCase;
import equinton.dev.kata.yatzy.domain.Category;

public class Yatzy {

  protected int[] dice;

  public Yatzy(int... dices) {
    this.dice = dices;
  }
  public static int chance(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.CHANCE, dices);
  }

  public static int ones(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.ONES, dices);
  }

  public static int twos(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TWOS, dices);
  }

  public static int threes(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TREES, dices);
  }


  public int fours() {
    return new CalculateYatzyScoreUseCase().execute(Category.FOURS, this.dice);
  }

  public int fives() {
    return new CalculateYatzyScoreUseCase().execute(Category.FIVES, this.dice);
  }

  public int sixes() {
    return new CalculateYatzyScoreUseCase().execute(Category.SIXES, this.dice);
  }

  public static int score_pair(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.PAIR, dices);
  }

  public static int two_pair(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TWO_PAIRS, dices);
  }

  public static int three_of_a_kind(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.TREE_OF_KIND, dices);
  }

  public static int four_of_a_kind(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.FOUR_OF_KIND, dices);
  }

  public static int smallStraight(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.SMALL_STRAIGHT, dices);
  }

  public static int largeStraight(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.LARGE_STRAIGHT, dices);
  }

  public static int fullHouse(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.FULL_HOUSE, dices);
  }

  public static int yatzy(int... dices) {
    return new CalculateYatzyScoreUseCase().execute(Category.YATZY, dices);
  }
}
