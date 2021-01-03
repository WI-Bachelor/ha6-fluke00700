package htw.berlin.ui;

import htw.berlin.domain.Burger;
import htw.berlin.domain.Ingredient;
import htw.berlin.service.BurgerBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class BurgerBotCommandsTest {

  @Mock
  private InputParser inputParser;

  @Mock
  private BurgerBuilder burgerBuilder;

  @Mock
  private InputEventPublisher inputEventPublisher;

  @InjectMocks
  private BurgerBotCommands classUnderTest;

  @Test
  @DisplayName("should pass user input to input parser")
  void shouldPassInputToParser() {
    String input = "Ich haette gernen ein Burger mit Rindfleisch und Tomate";
    classUnderTest.order(input);
    verify(inputParser).parseIngredientsFromOrder(input);
  }

  @Test
  @DisplayName("should print the whole menu if the input was not understood")
  void printMenu() {
    doReturn(emptyList()).when(inputParser).parseIngredientsFromOrder(anyString());
    var actual = classUnderTest.order("any order");
    assertTrue(actual.startsWith("Entschuldigung, ich habe dich nicht verstanden. Waehle aus folgenden Zutaten: " + Menu.getInstance().printAllIngredients()));
  }

  @Test
  @DisplayName("should build a burger with the parsed ingredients")
  void buildBurger() {
    List<Ingredient> ingredients = Collections.nCopies(3, mock(Ingredient.class));
    doReturn(ingredients).when(inputParser).parseIngredientsFromOrder(anyString());
    doReturn(burgerBuilder).when(burgerBuilder).addIngredients(anyList());
    doReturn(mock(Burger.class)).when(burgerBuilder).build();

    classUnderTest.order("any order");

    verify(burgerBuilder).addIngredients(ingredients);
    verify(burgerBuilder).build();
  }

  @Test
  @DisplayName("should return single burger order summary")
  void returnSingleBurgerOrderSummary() {
    Ingredient bunMock = mock(Ingredient.class);
    doReturn("Burgerbrot").when(bunMock).toString();
    Ingredient veggieMock = mock(Ingredient.class);
    doReturn("Tomate").when(veggieMock).toString();
    Burger burgerMock = mock(Burger.class);
    doReturn(List.of(bunMock, veggieMock)).when(burgerMock).getIngredients();
    doReturn(new BigDecimal("3.70")).when(burgerMock).calculatePrice();
    doReturn(List.of(bunMock, veggieMock)).when(inputParser).parseIngredientsFromOrder(anyString());
    doReturn(burgerBuilder).when(burgerBuilder).addIngredients(anyList());
    doReturn(burgerMock).when(burgerBuilder).build();

    String orderSummary = classUnderTest.order("any order");

    var expectedOrderSummary = "In Ordnung. Dein 1. Burger mit [Burgerbrot, Tomate] kostet 3.70 EUR.\nGib <confirm> ein, " +
                               "um die Bestellung abzuschliessen oder bestelle einen weiteren Burger mit <order -t '...'>";
    assertEquals(expectedOrderSummary, orderSummary);
  }

  @Test
  @DisplayName("should return order confirmation")
  void returnOrderConfirmation() {
    Burger burgerMock1 = mock(Burger.class);
    Burger burgerMock2 = mock(Burger.class);
    doReturn(new BigDecimal("7.50")).when(burgerMock1).calculatePrice();
    doReturn(new BigDecimal("5.30")).when(burgerMock2).calculatePrice();
    classUnderTest.orderedBurgers.addAll(List.of(burgerMock1, burgerMock2));

    String actual = classUnderTest.confirm();

    var expectedMessage = "Vielen Dank fuer deine Bestellung. Du hast 2 Burger bestellt. Die Gesamtsumme betraegt 12.80 EUR.";
    assertEquals(expectedMessage, actual);
  }
}
