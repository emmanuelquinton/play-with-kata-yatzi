package equinton.dev.kata.yatzy.domain.model;

public class CategoryNotNullSpecification implements Specification<Category> {

  @Override
  public boolean isSatifiedBy(Category category) {
    return category != null;
  }
}
