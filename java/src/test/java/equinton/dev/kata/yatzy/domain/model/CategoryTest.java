package equinton.dev.kata.yatzy.domain.model;

import equinton.dev.kata.yatzy.domain.model.Category;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {

  @ParameterizedTest
  @ValueSource(strings = {
      "CHANCE", "ONES", "TWOS", "TREES","FOURS", "FIVES", "SIXES",
      "PAIR", "TWO_PAIRS",
      "TREE_OF_KIND","FOUR_OF_KIND",
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
