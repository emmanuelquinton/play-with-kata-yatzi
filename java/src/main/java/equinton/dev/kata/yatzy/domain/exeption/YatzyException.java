package equinton.dev.kata.yatzy.domain.exeption;

public abstract class YatzyException extends RuntimeException {

  private final String code;
  private final String message;

  protected YatzyException(String code, String message) {
    super(message);
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return this.code;
  }

  @Override
  public String getMessage() {
    return this.message;
  }
}
