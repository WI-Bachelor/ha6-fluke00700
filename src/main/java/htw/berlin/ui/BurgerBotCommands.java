package htw.berlin.ui;

import htw.berlin.domain.Burger;
import htw.berlin.domain.Ingredient;
import htw.berlin.service.BurgerBuilder;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// TODO (2) Annotations @ShellComponent, @ShellCommand, und @ShellOption verwenden
@ShellComponent
public class BurgerBotCommands {

  final List<Burger> orderedBurgers;
  private final InputParser inputParser;
  private final BurgerBuilder burgerBuilder;
  private final InputEventPublisher inputEventPublisher;
  private final Menu menu;

  public BurgerBotCommands(InputParser inputParser, BurgerBuilder burgerBuilder, InputEventPublisher inputEventPublisher) {
    this.inputEventPublisher = inputEventPublisher;
    this.orderedBurgers = new ArrayList<>();
    this.inputParser = inputParser;
    this.burgerBuilder = burgerBuilder;
    this.menu = Menu.getInstance();
  }
  @ShellMethod("order something")
  public String order(@ShellOption("--text")String inputLine) {
    // DONE TODO (3) inputParser, burgerBuilder, menu, orderedBurgers nutzen, um Bestellungen aufzunehmen
    List<Ingredient> ingredientList = inputParser.parseIngredientsFromOrder(inputLine);
    String failedOrder = ("Entschuldigung, ich habe dich nicht verstanden. Waehle aus folgenden Zutaten: " + Menu.getInstance().printAllIngredients());
    inputEventPublisher.publishInputEvent(!ingredientList.isEmpty());
    if(ingredientList.isEmpty())
      return failedOrder;
    else {
      BurgerBuilder burger = burgerBuilder.addIngredients(ingredientList);
      this.orderedBurgers.add(burger.build());
      int currentBurger = orderedBurgers.size();
      Burger currentBurgerordered = this.orderedBurgers.get(currentBurger - 1);

      String orderSuccessful = "In Ordnung. Dein " + currentBurger + ". Burger mit " + currentBurgerordered.getIngredients().toString() + " kostet " + currentBurgerordered.calculatePrice()
              + " EUR.\nGib <confirm> ein, " + "um die Bestellung abzuschliessen oder bestelle einen weiteren Burger mit <order -t '...'>";
      return orderSuccessful;
    }
    // TODO (5) Klasse BurgerBotPromptProvider erstellen und dann inputEventPublisher für Prompt-Updates nutzen
  }

  @ShellMethod("confirms all orders up to now")
  public String confirm() {
    // DONE TODO (4) Preis der gesamten Bestellung mithilfe von orderedBurgers berechnen
      var totalPrice = new BigDecimal(0);
      for (Burger burger : this.orderedBurgers) {
        totalPrice = totalPrice.add(burger.calculatePrice());
      }
      return "Vielen Dank fuer deine Bestellung. Du hast " + this.orderedBurgers.size() + " Burger bestellt. Die Gesamtsumme betraegt " + totalPrice + " EUR.";

  }
}
