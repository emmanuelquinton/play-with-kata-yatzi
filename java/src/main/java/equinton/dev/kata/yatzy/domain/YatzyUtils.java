package equinton.dev.kata.yatzy.domain;

import equinton.dev.kata.yatzy.domain.model.Die;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class YatzyUtils {

    private YatzyUtils() {
    }

    public static int getContractScore(int contract, Die[] dice) {
    return Arrays.stream(dice)
        .mapToInt(Die::value)
        .filter(diceValue -> diceValue == contract)
        .sum();
  }

  public static int chance(Die...dice) {
    return Arrays.stream(dice).mapToInt(Die::value).sum();
  }

  public static Map<Integer, Long> groupDiceByFace(Die[] dice) {
    return Arrays.stream(dice)
        .mapToInt(Die::value)
        .mapToObj(Integer::valueOf)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static String getStraight(Die[] dice) {
    return Arrays.stream(dice).mapToInt(die ->die.value()).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
  }

  public static int getValuesRepresentedMoreNTimesAndMultiplyByN(
     int valueObtainedNTimes, Die...diceRoll) {
      Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
    return groupedDiceValues.entrySet().stream()
        .filter(entry -> entry.getValue() >= valueObtainedNTimes)
        .map(Map.Entry::getKey)
        .mapToInt(diceFace -> diceFace.intValue() * valueObtainedNTimes)
        .sum();
  }
}
