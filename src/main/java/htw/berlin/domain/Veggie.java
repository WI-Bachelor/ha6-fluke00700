package htw.berlin.domain;

import java.math.BigDecimal;

public class Veggie extends AbstractIngredient{

    public Veggie(Integer id, String name, BigDecimal price) {
        super(id, name, price);
    }

    public String toString() {
        return String.format("%s als Gemuesebeilage", getName());
    }
}
