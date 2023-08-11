package equinton.dev.kata.yatzy.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class YatzyUtils {

  public static int getContractScore(int contract, int[] dices) {
    return Arrays.stream(dices).filter(diceValue -> diceValue == contract).sum();
  }

  public static int chance(int... dices) {
    return Arrays.stream(dices).sum();
  }

  public static Map<Integer, Long> groupDiceByFace(int[] dices) {
    return Arrays.stream(dices)
        .mapToObj(Integer::valueOf)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
  }

  public static String getStraight(int[] dices) {
    return Arrays.stream(dices).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
  }

  public static int getValuesRepresentedMoreNTimesAndMultiplyByN(
     int valueObtainedNTimes, int...diceRoll) {
      Map<Integer, Long> groupedDiceValues = groupDiceByFace(diceRoll);
    return groupedDiceValues.entrySet().stream()
        .filter(entry -> entry.getValue() >= valueObtainedNTimes)
        .map(Map.Entry::getKey)
        .mapToInt(diceFace -> diceFace.intValue() * valueObtainedNTimes)
        .sum();
  }
}
