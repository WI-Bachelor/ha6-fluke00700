package htw.berlin.ui;

import htw.berlin.service.BurgerBuilderImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BurgerBotCommandsIntegrationTest {

  private BurgerBotCommands classUnderTest;

  @BeforeEach
  void setup() {
    classUnderTest = new BurgerBotCommands(
        new InputParserImpl(new CommaAndWhitespaceSplittingKeywordCounter()),
        new BurgerBuilderImpl(),
        new InputEventPublisher());
  }

  @Test
  @DisplayName("should understand a simple order and list the burger's individual ingredients and it's price")
  void testSimpleOrder() {
    String simpleOrder = "Ich haette gerne einen Burger mit Burgerbrot Rindfleisch, Eisbergsalat, Tomate und Ketchup";

    var actual = classUnderTest.order(simpleOrder);

    var expectedMessage = "In Ordnung. Dein 1. Burger mit [Burgerbrot, Rindfleisch, Eisbergsalat als Salatbeilage, " +
                          "Tomate als Gemuesebeilage, Ketchup als Sauce] kostet 7.35 EUR.";
    assertTrue(actual.startsWith(expectedMessage));
  }

  @Test
  @DisplayName("should understand a special order and list the burger's individual ingredients and it's price")
  void testSpecialOrder() {
    String simpleOrder = "Ich haette gerne ein Ciabatta mit Falafel, Rucolasalat, Tomate, Gurke und Mayo";

    var actual = classUnderTest.order(simpleOrder);

    String expectedMessage = "In Ordnung. Dein 1. Burger mit [Ciabatta, Falafel, Rucolasalat als Salatbeilage, " +
                             "Tomate als Gemuesebeilage, Gurke als Gemuesebeilage, Mayo als Sauce] kostet 7.65 EUR.";
    assertTrue(actual.startsWith(expectedMessage));
  }
}
