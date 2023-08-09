package equinton.dev.kata.yatzy.domain;

import java.util.Arrays;

public class CalculateYatzyScoreUseCase {
    public int execute(Category category, int[] roll) {
        if(category == Category.CHANCE) {
           return  Arrays.stream(roll).sum();
        }
        return 0;
    }
}
