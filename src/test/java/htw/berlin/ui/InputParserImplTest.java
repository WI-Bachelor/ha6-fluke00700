package htw.berlin.ui;

import htw.berlin.domain.Ingredient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InputParserImplTest {

  @Test
  @DisplayName("should parse the correct ingredients from input")
  void canParseIngredients() {
    KeywordCounter keywordCounter = mock(KeywordCounter.class);
    when(keywordCounter.countKeywords(anyString(), anySet())).thenReturn(Map.of(
        "Burger", 1,
        "Ciabatta", 0,
        "Rindfleisch", 0,
        "Falafel", 0,
        "Eisbergsalat", 0,
        "Rucolasalat", 0,
        "Tomate", 1,
        "Gurke", 0,
        "Ketchup", 0,
        "Mayo", 0
    ));
    InputParser inputParser = new InputParserImpl(keywordCounter);

    var actual = inputParser.parseIngredientsFromOrder("Ich haette gerne einen Burger mit Tomate");

    Map<String, Ingredient> allIngredients = Menu.getInstance().getAllIngredients();
    assertTrue(actual.contains(allIngredients.get("Burger")));
    assertTrue(actual.contains(allIngredients.get("Tomate")));
  }

  @Test
  @DisplayName("should parse the correct ingredients if they ordered multiple times")
  void canParseIngredientsMultipleTimes() {
    KeywordCounter keywordCounter = mock(KeywordCounter.class);
    when(keywordCounter.countKeywords(anyString(), anySet())).thenReturn(Map.of(
        "Burger", 1,
        "Ciabatta", 0,
        "Rindfleisch", 3,
        "Falafel", 0,
        "Eisbergsalat", 0,
        "Rucolasalat", 0,
        "Tomate", 1,
        "Gurke", 0,
        "Ketchup", 0,
        "Mayo", 0
    ));
    InputParser inputParser = new InputParserImpl(keywordCounter);

    var actual = inputParser.parseIngredientsFromOrder("Ich haette gerne einen Burger mit Tomate");

    Map<String, Ingredient> allIngredients = Menu.getInstance().getAllIngredients();
    assertTrue(actual.contains(allIngredients.get("Burger")));
    assertTrue(actual.contains(allIngredients.get("Rindfleisch")));
    assertTrue(actual.contains(allIngredients.get("Rindfleisch")));
    assertTrue(actual.contains(allIngredients.get("Rindfleisch")));
    assertTrue(actual.contains(allIngredients.get("Tomate")));
  }
}
