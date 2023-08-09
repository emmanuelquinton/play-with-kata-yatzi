package equinton.dev.kata.yatzy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Yatzy {
    public static int yatzy(int... dices)
    {
        var groupedDiceValues = groupDiceByFace(dices);
        if(groupedDiceValues.keySet().size()==1) {
            return 50;
        }
        return 0;
    }

    public static int chance(int...dices)
    {
        return Arrays.stream(dices).sum();

    }


    public static int ones(int...dices) {
        int contract = 1;
        return getContractScore(contract, dices);

    }
    public static int twos(int...dices) {
        int contract = 2;
        return getContractScore(contract, dices);
    }

    public static int threes(int...dices) {
        int contract = 3;
        return getContractScore(contract, dices);
    }

    public int fours()
    {
        int contract = 4;
        return getContractScore(contract, this.dice);
    }

    public int fives()
    {
        int contract = 5;
        return getContractScore(contract, this.dice);
    }

    public int sixes()
    {
        int contract = 6;
        return getContractScore(contract, this.dice);
    }
    private static int getContractScore(int contract, int[] dices) {
        return Arrays.stream(dices).filter(diceValue -> diceValue == contract)
            .sum();

    }


    protected int[] dice;
    public Yatzy(int...dices)
    {
        this.dice = dices;
    }


    public static int score_pair(int...dices)
    {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(dices);

        var valuePairFace = groupedDiceValues.entrySet().stream()
            .filter(entry -> entry.getValue() == 2)
            .map(Map.Entry::getKey)
            .max(Comparable::compareTo)
            .orElseGet(() -> 0);
        return valuePairFace*2;

    }

    public static int two_pair(int...dices)
    {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(dices);
        return groupedDiceValues.entrySet().stream()
            .filter(entry -> entry.getValue() >= 2)
            .map(Map.Entry::getKey)
            .mapToInt(diceFace -> diceFace.intValue()*2)
            .sum();

    }
    public static int four_of_a_kind(int...dices)
    {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(dices);
        return groupedDiceValues.entrySet().stream()
            .filter(entry -> entry.getValue() >= 4)
            .map(Map.Entry::getKey)
            .mapToInt(diceFace -> diceFace.intValue()*4)
            .sum();
    }

    private static Map<Integer, Long> groupDiceByFace(int[] dices) {
        return Arrays.stream(dices).mapToObj(Integer::valueOf)
            .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }



    public static int three_of_a_kind(int...dices)
    {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(dices);
        return groupedDiceValues.entrySet().stream()
            .filter(entry -> entry.getValue() >= 3)
            .map(Map.Entry::getKey)
            .mapToInt(diceFace -> diceFace.intValue()*3)
            .sum();
    }

    public static int smallStraight(int...dices)
    {
        var straight = getStraight(dices);
        if(straight.equals("12345")){
            return 15;
        }
        return 0;
    }

    public static int largeStraight(int...dices)
    {
        var straight = getStraight(dices);
        if(straight.equals("23456")){
            return 20;
        }
        return 0;
    }
    private static String getStraight(int[] dices) {
        return Arrays.stream(dices).sorted().mapToObj(String::valueOf).collect(Collectors.joining());
    }


    public static int fullHouse(int...dices)
    {
        Map<Integer, Long> groupedDiceValues = groupDiceByFace(dices);
        if(groupedDiceValues.keySet().size() != 2) {
            return 0;
        }

        return chance(dices);

    }
}



