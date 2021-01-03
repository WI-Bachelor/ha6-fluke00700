package htw.berlin.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BurgerImplTest {

  @Test
  @DisplayName("should calculate total price of a burger")
  void testCalculatePrice() {
    Ingredient testBun = Mockito.mock(Ingredient.class);
    Ingredient testSalat = Mockito.mock(Ingredient.class);
    when(testBun.getPrice()).thenReturn(new BigDecimal("1.50"));
    when(testSalat.getPrice()).thenReturn(new BigDecimal("0.50"));

    List<Ingredient> ingredients = List.of(testBun, testSalat);
    Burger burger = new BurgerImpl(ingredients);

    assertEquals(new BigDecimal("2.00"), burger.calculatePrice());
  }
}