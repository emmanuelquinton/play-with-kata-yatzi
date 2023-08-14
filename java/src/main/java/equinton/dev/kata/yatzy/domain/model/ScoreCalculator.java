package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.YatzyUtils;

import java.util.EnumSet;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static equinton.dev.kata.yatzy.domain.YatzyUtils.*;

public enum ScoreCalculator {
  CHANCE_CALCULATOR(Category.CHANCE) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(YatzyUtils.chance(roll.dice()));
      }
  },
  ONES_CALCULATOR(Category.ONES) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(1, roll.dice()));
      }
  },
  TWO_CALCULATOR(Category.TWOS) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(2, roll.dice()));
      }
  },
  TREES_CALCULATOR(Category.TREES) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(3, roll.dice()));
      }
  },
  FOURS_CALCULATOR(Category.FOURS) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(4, roll.dice()));
      }
  },
  FIVES_CALCULATOR(Category.FIVES) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(5, roll.dice()));
      }
  },
  SIXES_CALCULATOR(Category.SIXES) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getContractScore(6, roll.dice()));
      }
  },
  PAIR_CALCULATOR(Category.PAIR) {
      @Override
      public Score calculate(Roll roll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(roll.dice());
          Predicate<Map.Entry<Integer, Long>> entryPredicate = entry -> entry.getValue() >= 2;
          var valuePairFace =
              groupedDiceValues.entrySet().stream()
                  .filter(entryPredicate)
                  .map(Map.Entry::getKey)
                  .max(Comparable::compareTo)
                  .orElseGet(() -> 0);
          return new Score(valuePairFace * 2);
      }
  },
  TWO_PAIRS_CALCULATOR(Category.TWO_PAIRS) {
      @Override
      public Score calculate(Roll roll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(roll.dice());
          var diceFaceWithPair =
              groupedDiceValues.entrySet().stream().filter(entry -> entry.getValue() >= 2).toList();
          if (diceFaceWithPair.size() == 2) {
              return new Score(diceFaceWithPair.stream()
                  .map(Map.Entry::getKey)
                  .mapToInt(diceFace -> diceFace.intValue() * 2)
                  .sum());
          }
          return new Score(0);
      }
  },
  TREE_OF_KIND_CALCULATOR(Category.TREE_OF_KIND) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getValuesRepresentedMoreNTimesAndMultiplyByN(3, roll.dice()));
      }
  },
  FOUR_OF_KIND_CALCULATOR(Category.FOUR_OF_KIND) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(getValuesRepresentedMoreNTimesAndMultiplyByN(4, roll.dice()));
      }
  },
  SMALL_STRAIGHT_CALCULATOR(Category.SMALL_STRAIGHT) {
      @Override
      public Score calculate(Roll roll) {
          var straight = getStraight(roll.dice());
          if (straight.equals("12345")) {
              return new Score(15);
          }
          return new Score(0);
      }
  },
  LARGE_STRAIGHT_CALCULATOR(Category.LARGE_STRAIGHT) {
      @Override
      public Score calculate(Roll roll) {
          var straight = getStraight(roll.dice());
          if (straight.equals("23456")) {
              return new Score(20);
          }
          return new Score(0);
      }
  },
  FULL_HOUSE_CALCULATOR(Category.FULL_HOUSE) {
      @Override
      public Score calculate(Roll roll) {
          Map<Integer, Long> groupedDiceValues = groupDiceByFace(roll.dice());
          if(groupedDiceValues.keySet().size() != 2) {
              return new Score(0);
          }
          return new Score(chance(roll.dice()));
      }
  },
  YATZY_CALCULATOR(Category.YATZY) {
      @Override
      public Score calculate(Roll roll) {
          return new Score(YatzyUtils.groupDiceByFace(roll.dice()).size()==1?50:0);
      }
  };

  private static Map<Category, ScoreCalculator> categoriesCalculators =
      EnumSet.allOf(ScoreCalculator.class).stream()
          .collect(
              Collectors.toMap(ScoreCalculator::getCategory, scoreCalculator -> scoreCalculator));

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

  public abstract Score calculate(Roll roll);
}
