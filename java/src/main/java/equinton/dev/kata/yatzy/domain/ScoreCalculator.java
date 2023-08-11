package equinton.dev.kata.yatzy.domain;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static equinton.dev.kata.yatzy.domain.YatzyUtils.*;

public enum ScoreCalculator {
  CHANCE_CALCULATOR(Category.CHANCE) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.chance(diceRoll);
      }
  },
  ONES_CALCULATOR(Category.ONES) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(1, diceRoll);
      }
  },
  TWO_CALCULATOR(Category.TWOS) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(2, diceRoll);
      }
  },
  TREES_CALCULATOR(Category.TREES) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(3, diceRoll);
      }
  },
  FOURS_CALCULATOR(Category.FOURS) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(4, diceRoll);
      }
  },
  FIVES_CALCULATOR(Category.FIVES) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(5, diceRoll);
      }
  },
  SIXES_CALCULATOR(Category.SIXES) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.getContractScore(6, diceRoll);
      }
  },
  PAIR_CALCULATOR(Category.PAIR) {
      @Override
      public int calculate(int[] diceRoll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
          Predicate<Map.Entry<Integer, Long>> entryPredicate = entry -> entry.getValue() >= 2;
          var valuePairFace =
              groupedDiceValues.entrySet().stream()
                  .filter(entryPredicate)
                  .map(Map.Entry::getKey)
                  .max(Comparable::compareTo)
                  .orElseGet(() -> 0);
          return valuePairFace * 2;
      }
  },
  TWO_PAIRS_CALCULATOR(Category.TWO_PAIRS) {
      @Override
      public int calculate(int[] diceRoll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
          var diceFaceWithPair =
              groupedDiceValues.entrySet().stream().filter(entry -> entry.getValue() >= 2).toList();
          if (diceFaceWithPair.size() == 2) {
              return diceFaceWithPair.stream()
                  .map(Map.Entry::getKey)
                  .mapToInt(diceFace -> diceFace.intValue() * 2)
                  .sum();
          }
          return 0;
      }
  },
  TREE_OF_KIND_CALCULATOR(Category.TREE_OF_KIND) {
      @Override
      public int calculate(int[] diceRoll) {
          return getValuesRepresentedMoreNTimesAndMultiplyByN(3, diceRoll);
      }
  },
  FOUR_OF_KIND_CALCULATOR(Category.FOUR_OF_KIND) {
      @Override
      public int calculate(int[] diceRoll) {
          return getValuesRepresentedMoreNTimesAndMultiplyByN(4, diceRoll);
      }
  },
  SMALL_STRAIGHT_CALCULATOR(Category.SMALL_STRAIGHT) {
      @Override
      public int calculate(int[] diceRoll) {
          var straight = getStraight(diceRoll);
          if (straight.equals("12345")) {
              return 15;
          }
          return 0;
      }
  },
  LARGE_STRAIGHT_CALCULATOR(Category.LARGE_STRAIGHT) {
      @Override
      public int calculate(int[] diceRoll) {
          var straight = getStraight(diceRoll);
          if (straight.equals("23456")) {
              return 20;
          }
          return 0;
      }
  },
  FULL_HOUSE_CALCULATOR(Category.FULL_HOUSE) {
      @Override
      public int calculate(int[] diceRoll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
          if(groupedDiceValues.keySet().size() != 2) {
              return 0;
          }
          return chance(diceRoll);
      }
  },
  YATZY_CALCULATOR(Category.YATZY) {
      @Override
      public int calculate(int[] diceRoll) {
          return YatzyUtils.groupDiceByFace(diceRoll).size()==1?50:0;
      }
  };

  private static Map<Category, ScoreCalculator> categoriesCalculators =
      EnumSet.allOf(ScoreCalculator.class).stream()
          .collect(
              Collectors.toMap(
                  scoreCalculator -> scoreCalculator.getCategory(),
                  scoreCalculator -> scoreCalculator));

  private final Category category;

  ScoreCalculator(Category category) {

    this.category = category;
  }

  public Category getCategory() {
    return category;
  }

  public static ScoreCalculator getByCategory(Category category) {
    return categoriesCalculators.get(category);
  }

  public abstract int calculate(int[] diceRoll);
}
