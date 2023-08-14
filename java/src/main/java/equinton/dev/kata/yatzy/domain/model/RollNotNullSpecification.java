package equinton.dev.kata.yatzy.domain.model;

public class RollNotNullSpecification implements Specification<Roll>{


    @Override
    public boolean isSatifiedBy(Roll roll) {
        return roll != null;
    }


}
