package htw.berlin.domain;

import java.math.BigDecimal;

public class Patty extends AbstractIngredient {

  public Patty(Integer id, String name, BigDecimal price) {
    super(id, name, price);
  }

  @Override
  public String toString() {
    return getName();
  }
}
