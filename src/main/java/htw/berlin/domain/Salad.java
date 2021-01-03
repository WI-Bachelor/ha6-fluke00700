package htw.berlin.domain;

import java.math.BigDecimal;

public class Salad extends AbstractIngredient {

    public Salad(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public String toString() {
        return String.format("%s als Salatbeilage", getName());
    }
}
