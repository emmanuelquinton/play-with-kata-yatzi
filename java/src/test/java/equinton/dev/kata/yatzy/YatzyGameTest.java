package equinton.dev.kata.yatzy;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class YatzyGameTest {

    @Test

    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yatzy.chance(2,3,4,5,1);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(Yatzy.chance(3,3,4,5,1)).isEqualTo(16);
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = Yatzy.yatzy(4,4,4,4,4);
        Assertions.assertThat(actual).isEqualTo(expected);
        Assertions.assertThat(Yatzy.yatzy(6,6,6,6,6)).isEqualTo(50);
        Assertions.assertThat(Yatzy.yatzy(6,6,6,6,3)).isEqualTo(0);
    }

    @Test public void test_1s() {
        Assertions.assertThat(Yatzy.ones(1,2,3,4,5)).isEqualTo(1);
        Assertions.assertThat(Yatzy.ones(1,2,1,4,5)).isEqualTo(2);
        Assertions.assertThat( Yatzy.ones(6,2,2,4,5)).isEqualTo(0);
        Assertions.assertThat( Yatzy.ones(1,2,1,1,1)).isEqualTo(4);
    }

    @Test
    public void test_2s() {
        Assertions.assertThat( Yatzy.twos(1,2,3,2,6)).isEqualTo(4);
        Assertions.assertThat(Yatzy.twos(2,2,2,2,2)).isEqualTo(10);
    }

    @Test
    public void test_threes() {
        Assertions.assertThat(Yatzy.threes(1,2,3,2,3)).isEqualTo(6);
        Assertions.assertThat(Yatzy.threes(2,3,3,3,3)).isEqualTo(12);
    }

    @Test
    public void fours_test()
    {
        Assertions.assertThat( new Yatzy(4,4,4,5,5).fours()).isEqualTo(12);
        Assertions.assertThat( new Yatzy(4,4,5,5,5).fours()).isEqualTo(8);
        Assertions.assertThat( new Yatzy(4,5,5,5,5).fours()).isEqualTo(4);
    }

    @Test
    public void fives() {
        Assertions.assertThat(new Yatzy(4,4,4,5,5).fives()).isEqualTo(10);
        Assertions.assertThat( new Yatzy(4,4,5,5,5).fives()).isEqualTo(15);
        Assertions.assertThat( new Yatzy(4,5,5,5,5).fives()).isEqualTo(20);
    }

    @Test
    public void sixes_test() {
        Assertions.assertThat( new Yatzy(4,4,4,5,5).sixes()).isEqualTo(0);
        Assertions.assertThat(new Yatzy(4,4,6,5,5).sixes()).isEqualTo(6);
        Assertions.assertThat( new Yatzy(6,5,6,6,5).sixes()).isEqualTo(18);
    }

    @Test
    public void one_pair() {
        Assertions.assertThat( Yatzy.score_pair(3,4,3,5,6)).isEqualTo(6);
        Assertions.assertThat( Yatzy.score_pair(5,3,3,3,5)).isEqualTo(10);
        Assertions.assertThat( Yatzy.score_pair(5,3,6,6,5)).isEqualTo(12);
    }

    @Test
    public void two_Pair() {
        Assertions.assertThat(Yatzy.two_pair(3,3,5,4,5)).isEqualTo(16);
        Assertions.assertThat(Yatzy.two_pair(3,3,5,5,5)).isEqualTo(16);
    }

    @Test
    public void three_of_a_kind()
    {
        Assertions.assertThat( Yatzy.three_of_a_kind(3,3,3,4,5)).isEqualTo(9);
        Assertions.assertThat( Yatzy.three_of_a_kind(5,3,5,4,5)).isEqualTo(15);
        Assertions.assertThat( Yatzy.three_of_a_kind(3,3,3,3,5)).isEqualTo(9);
    }

    @Test
    public void four_of_a_knd() {
        Assertions.assertThat(Yatzy.four_of_a_kind(3,3,3,3,5)).isEqualTo(12);
        Assertions.assertThat(Yatzy.four_of_a_kind(5,5,5,4,5)).isEqualTo(20);
        Assertions.assertThat(Yatzy.three_of_a_kind(3,3,3,3,3)).isEqualTo(9);
    }

    @Test
    public void smallStraight() {
        Assertions.assertThat(Yatzy.smallStraight(1,2,3,4,5)).isEqualTo(15);
        Assertions.assertThat(Yatzy.smallStraight(2,3,4,5,1)).isEqualTo(15);
        Assertions.assertThat(Yatzy.smallStraight(1,2,2,4,5)).isEqualTo(0);
    }

    @Test
    public void largeStraight() {
        Assertions.assertThat(Yatzy.largeStraight(6,2,3,4,5)).isEqualTo(20);
        Assertions.assertThat(Yatzy.largeStraight(2,3,4,5,6)).isEqualTo(20);
        Assertions.assertThat(Yatzy.largeStraight(1,2,2,4,5)).isEqualTo(0);
    }

    @Test
    public void fullHouse() {
        Assertions.assertThat(Yatzy.fullHouse(6,2,2,2,6)).isEqualTo(18);
        Assertions.assertThat(Yatzy.fullHouse(2,3,4,5,6)).isEqualTo(0);
    }
}
