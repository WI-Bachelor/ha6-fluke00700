package htw.berlin.ui;

import htw.berlin.domain.Bun;
import htw.berlin.domain.Ingredient;
import htw.berlin.domain.Patty;
import htw.berlin.domain.Salad;
import htw.berlin.domain.Sauce;
import htw.berlin.domain.Veggie;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

// Eine statische Datenbank-Klasse
public class Menu {

    private static final String BURGER_NAME = "Burgerbrot";
    private static final String CIABATTA_NAME = "Ciabatta";
    private static final String RINDFLEISCH_NAME = "Rindfleisch";
    private static final String FALAFEL_NAME = "Falafel";
    private static final String EISBERGSALAT_NAME = "Eisbergsalat";
    private static final String RUCOLASALAT_NAME = "Rucolasalat";
    private static final String TOMATE_NAME = "Tomate";
    private static final String GURKE_NAME = "Gurke";
    private static final String KETCHUP_NAME = "Ketchup";
    private static final String MAYO_NAME = "Mayo";
    private static final Menu INSTANCE = new Menu();

    private Map<String, Ingredient> ingredients;

    private Menu() {
        init();
    }

    private void init() {
        ingredients = new LinkedHashMap<>(); // to keep order of insertion
        ingredients.put(BURGER_NAME, new Bun(100, BURGER_NAME, new BigDecimal("1.50")));
        ingredients.put(CIABATTA_NAME, new Bun(200, CIABATTA_NAME, new BigDecimal("1.90")));
        ingredients.put(RINDFLEISCH_NAME, new Patty(300, RINDFLEISCH_NAME, new BigDecimal("4.50")));
        ingredients.put(FALAFEL_NAME, new Patty(400, FALAFEL_NAME, new BigDecimal("3.50")));
        ingredients.put(EISBERGSALAT_NAME, new Salad(500, EISBERGSALAT_NAME, new BigDecimal("0.40")));
        ingredients.put(RUCOLASALAT_NAME, new Salad(600, RUCOLASALAT_NAME, new BigDecimal("0.60")));
        ingredients.put(TOMATE_NAME, new Veggie(700, TOMATE_NAME, new BigDecimal("0.70")));
        ingredients.put(GURKE_NAME, new Veggie(800, GURKE_NAME, new BigDecimal("0.65")));
        ingredients.put(KETCHUP_NAME, new Sauce(900, KETCHUP_NAME, new BigDecimal("0.25")));
        ingredients.put(MAYO_NAME, new Sauce(1000, MAYO_NAME, new BigDecimal("0.30")));
    }

    public static Menu getInstance() {
        return INSTANCE;
    }

    public Map<String, Ingredient> getAllIngredients() {
        return ingredients;
    }

    public String printAllIngredients() {
        return String.join(", ", getAllIngredients().keySet());
    }
}
