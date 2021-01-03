package htw.berlin.domain;

import java.math.BigDecimal;

public abstract class AbstractIngredient implements Ingredient {

  private final Integer id;
  private final String name;
  private final BigDecimal price;

  public AbstractIngredient(Integer id, String name, BigDecimal price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public BigDecimal getPrice() {
    return price;
  }
}
