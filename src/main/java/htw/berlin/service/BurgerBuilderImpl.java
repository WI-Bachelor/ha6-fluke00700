package htw.berlin.service;

import htw.berlin.domain.Burger;
import htw.berlin.domain.BurgerImpl;
import htw.berlin.domain.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BurgerBuilderImpl implements BurgerBuilder {

  private final List<Ingredient> ingredients;

  public BurgerBuilderImpl() {
    this.ingredients = new ArrayList<>();
  }

  @Override
  public BurgerBuilder addIngredients(List<Ingredient> ingredients) {
    this.ingredients.addAll(ingredients);
    return this;
  }

  @Override
  public List<Ingredient> getIngredients() {
    return ingredients;
  }

  @Override
  public Burger build() {
    Burger burger = new BurgerImpl(new ArrayList<>(ingredients));
    ingredients.clear();
    return burger;
  }
}
