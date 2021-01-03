package htw.berlin.service;

import htw.berlin.domain.Burger;
import htw.berlin.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BurgerBuilderImplTest {

  @Test
  @DisplayName("should build a burger from articles")
  void testBuildBurger() {
    BurgerBuilder burgerBuilder = new BurgerBuilderImpl();
    Ingredient testBun = Mockito.mock(Ingredient.class);
    Ingredient testSalad = Mockito.mock(Ingredient.class);
    burgerBuilder.addIngredients(List.of(testBun, testSalad));

    Burger burger = burgerBuilder.build();

    assertEquals(2, burger.getIngredients().size());
    assertTrue(burger.getIngredients().contains(testBun));
    assertTrue(burger.getIngredients().contains(testSalad));
  }

  @Test
  @DisplayName("should clear the ingredients after building a burger")
  void shouldClearIngredients() {
    BurgerBuilder burgerBuilder = new BurgerBuilderImpl();
    Ingredient testBun = Mockito.mock(Ingredient.class);
    Ingredient testSalat = Mockito.mock(Ingredient.class);
    burgerBuilder.addIngredients(List.of(testBun, testSalat));

    burgerBuilder.build();

    assertTrue(burgerBuilder.getIngredients().isEmpty());
  }
}