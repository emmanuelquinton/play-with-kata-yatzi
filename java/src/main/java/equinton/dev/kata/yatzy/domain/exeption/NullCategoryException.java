package equinton.dev.kata.yatzy.domain.exeption;

public class NullCategoryException extends YatzyException {
  public NullCategoryException() {
    super("error.yatzy.category-is-null", "The category can't be null to calculate score.");
  }
}
