package htw.berlin.domain;

import java.math.BigDecimal;

public class Sauce extends AbstractIngredient{

    public Sauce(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public String toString() {
        return String.format("%s als Sauce", getName());
    }
}
