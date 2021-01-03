package htw.berlin.domain;

import java.math.BigDecimal;
import java.util.List;

public class BurgerImpl implements Burger {

  private final List<Ingredient> ingredients;

  public BurgerImpl(List<Ingredient> ingredients) {
    this.ingredients = ingredients;
  }

  @Override
  public BigDecimal calculatePrice() {
    BigDecimal total = new BigDecimal(0);
    for (Ingredient ing : ingredients) {
      total = total.add(ing.getPrice());
    }
    return total;
  }

  @Override
  public List<Ingredient> getIngredients() {
    return ingredients;
  }
}
