package equinton.dev.kata.yatzy.domain;

import static equinton.dev.kata.yatzy.domain.YatzyUtils.*;

import java.util.Map;
import java.util.function.Predicate;

public class CalculateYatzyScoreUseCase {
  public int execute(Category category, int[] diceRoll) {
    if (category == Category.CHANCE) {
      return YatzyUtils.chance(diceRoll);
    } else if (category == Category.ONES) {
      return YatzyUtils.getContractScore(1, diceRoll);
    } else if (category == Category.TWOS) {
      return YatzyUtils.getContractScore(2, diceRoll);
    } else if (category == Category.TREES) {
      return YatzyUtils.getContractScore(3, diceRoll);
    } else if (category == Category.FOURS) {
      return YatzyUtils.getContractScore(4, diceRoll);
    } else if (category == Category.FIVES) {
      return YatzyUtils.getContractScore(5, diceRoll);
    } else if (category == Category.SIXES) {
      return YatzyUtils.getContractScore(6, diceRoll);
    } else if (category == Category.PAIR) {
      Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
      Predicate<Map.Entry<Integer, Long>> entryPredicate = entry -> entry.getValue() >= 2;
      var valuePairFace =
          groupedDiceValues.entrySet().stream()
              .filter(entryPredicate)
              .map(Map.Entry::getKey)
              .max(Comparable::compareTo)
              .orElseGet(() -> 0);
      return valuePairFace * 2;
    } else if (category == Category.TWO_PAIRS) {
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

    } else if (category == Category.TREE_OF_KIND) {
      return getValuesRepresentedMoreNTimesAndMultiplyByN(3, diceRoll);
    } else if (category == Category.FOUR_OF_KIND) {
      return getValuesRepresentedMoreNTimesAndMultiplyByN(4, diceRoll);
    } else if (category == Category.SMALL_STRAIGHT) {
      var straight = getStraight(diceRoll);
      if (straight.equals("12345")) {
        return 15;
      }
      return 0;
    } else if (category == Category.LARGE_STRAIGHT) {
      var straight = getStraight(diceRoll);
      if (straight.equals("23456")) {
        return 20;
      }
      return 0;
    } else if (category == Category.FULL_HOUSE) {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
        if(groupedDiceValues.keySet().size() != 2) {
            return 0;
        }
        return chance(diceRoll);
    } else if (category == Category.YATZY) {
      return YatzyUtils.groupDiceByFace(diceRoll).size()==1?50:0;
    }
    return 0;
  }
}
