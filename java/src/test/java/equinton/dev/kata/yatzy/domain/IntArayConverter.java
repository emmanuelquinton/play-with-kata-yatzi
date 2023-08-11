package equinton.dev.kata.yatzy.domain;

import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ArgumentConverter;

public class IntArayConverter implements ArgumentConverter {
  @Override
  public Object convert(Object source, ParameterContext parameterContext)
      throws ArgumentConversionException {
    if (!(source instanceof String)) {
      throw new IllegalArgumentException("The argument should be a string: " + source);
    }
    return  (int[]) source;
  }
}
