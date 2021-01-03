package htw.berlin.service;

import htw.berlin.domain.Burger;
import htw.berlin.domain.Ingredient;

import java.util.List;

public interface BurgerBuilder {
    BurgerBuilder addIngredients(List<Ingredient> ingredients);
    List<Ingredient> getIngredients();
    Burger build();
}
