package equinton.dev.kata.yatzy.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "CHANCE", "ONES", "TWOS", "THREES","FOURS", "FIVES", "SIXES",
      "PAIR", "TWO_PAIRS",
      "THREE_OF_KIND","FOUR_OF_KIND",
      "SMALL_STRAIGHT", "LARGE_STRAIGHT",
      "FULL_HOUSE",
      "YATZY"
  })
  void should_return_category_from_name(String categoryName) {
    // when
    var actualCategory = Category.valueOf(categoryName);

    // then
    Assertions.assertThat(actualCategory).as("Check that category exists.").isNotNull();
  }
}
