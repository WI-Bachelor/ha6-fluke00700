package htw.berlin.ui;

import htw.berlin.domain.Ingredient;

import java.util.List;

public interface InputParser {

  List<Ingredient> parseIngredientsFromOrder(String inputLine);
}
