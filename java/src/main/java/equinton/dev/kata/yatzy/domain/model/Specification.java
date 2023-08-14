package equinton.dev.kata.yatzy.domain.model;

public interface Specification<T> {

    boolean isSatifiedBy(T value);
    default boolean isNotSatifiedBy(T value) {
        return !isSatifiedBy(value);
    }


}
