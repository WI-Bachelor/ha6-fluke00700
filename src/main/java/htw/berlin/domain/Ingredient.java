package htw.berlin.domain;

import java.math.BigDecimal;

public interface Ingredient {
  Integer getId();
  String getName();
  BigDecimal getPrice();
}
