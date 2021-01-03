package htw.berlin.ui;

import htw.berlin.domain.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class InputParserImpl implements InputParser {

  private final KeywordCounter keywordCounter;

  public InputParserImpl(KeywordCounter keywordCounter) {
    this.keywordCounter = keywordCounter;
  }

  @Override
  public List<Ingredient> parseIngredientsFromOrder(String inputLine) {
    Set<String> articles = Menu.getInstance().getAllIngredients().keySet();
    Map<String, Integer> articleCount = keywordCounter.countKeywords(inputLine, articles);
    Map<String, Ingredient> articleMap = Menu.getInstance().getAllIngredients();
    List<Ingredient> ingredients = new ArrayList<>();

    for (Map.Entry<String, Integer> entry : articleCount.entrySet()) {
      String articleName = entry.getKey();
      Ingredient ingredient = articleMap.get(articleName);
      int count = entry.getValue();

      for (int frequency = 0; frequency < count; frequency++) {
        ingredients.add(ingredient);
      }
    }

    return ingredients;
  }
}
