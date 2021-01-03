package htw.berlin.domain;

import java.math.BigDecimal;

public class Bun extends AbstractIngredient {

  public Bun(Integer id, String name, BigDecimal price) {
    super(id, name, price);
  }

  @Override
  public String toString() {
    return getName();
  }
}
