package htw.berlin.ui;

import htw.berlin.domain.Burger;
import htw.berlin.service.BurgerBuilder;
import java.util.ArrayList;
import java.util.List;

// TODO (2) Annotations @ShellComponent, @ShellCommand, und @ShellOption verwenden
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

  public String order(String inputLine) {
    // TODO (3) inputParser, burgerBuilder, menu, orderedBurgers nutzen, um Bestellungen aufzunehmen

    return "In Ordnung ...";
    // TODO (5) Klasse BurgerBotPromptProvider erstellen und dann inputEventPublisher für Prompt-Updates nutzen
  }

  public String confirm() {
    // TODO (4) Preis der gesamten Bestellung mithilfe von orderedBurgers berechnen

    return "Vielen Dank...";
  }
}
