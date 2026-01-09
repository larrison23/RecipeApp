package recipeapp;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecipeIngredient implements Comparable<RecipeIngredient>{
    private static final Map<Double, String> FRACTIONS = new LinkedHashMap<>();

    static {
        FRACTIONS.put(0.50, "1/2");
        FRACTIONS.put(0.25, "1/4");
        FRACTIONS.put(0.75, "3/4");
        FRACTIONS.put(1.0/3.0, "1/3");
        FRACTIONS.put(2.0/3.0, "2/3");
        FRACTIONS.put(0.125, "1/8");
        FRACTIONS.put(0.375, "3/8");
        FRACTIONS.put(0.625, "5/8");
        FRACTIONS.put(0.875, "7/8");
    }

    private final Ingredient ingredient;

    private double qty;
    private Unit unit;
    private boolean prep;
    private String prepNote;

    public RecipeIngredient(Ingredient ingredient, double qty, Unit unit, String prepNote) {
        if (qty < 0) {
            throw new IllegalArgumentException("Quantity can't be negative");
        }

        if (ingredient == null) {
            throw new IllegalArgumentException("Ingredient can't be null");
        }

        this.ingredient = ingredient;
        this.qty = qty;
        this.unit = unit;
        this.prepNote = (prepNote == null) ? "" : prepNote;
        this.prep = (!this.prepNote.equals(""));
    }

    public Ingredient getIngredient() {
        return ingredient;
    }
    public double getQuantity() {
        return qty;
    }
    public Unit getUnit() {
        return unit;
    }
    public boolean getPrep() {
        return prep;
    }
    public String getPrepNote() {
        return prepNote;
    }

    public void setPrepNote(String prepNote) {
        this.prepNote = prepNote;
        this.prep = true;
    }

    public void setQuantity(double qty) {
        this.qty = qty;
    }

    public void scale(double factor) {
        if (factor < 0) {
            throw new IllegalArgumentException("Factor can't be negative");
        }

        qty = qty * factor;
    }

    private String formatQuantity(double q) {
        int whole = (int) q;
        double fraction = q - whole;
        double tolerance = 0.01;

        String fractionStr = "";

        for (Map.Entry<Double, String> entry : FRACTIONS.entrySet()) {
            if (Math.abs(fraction - entry.getKey()) < tolerance) {
                fractionStr = entry.getValue();
                break;
            }
        }

       if (whole == 0 && !fractionStr.isEmpty()) return fractionStr;
       if (whole > 0 && !fractionStr.isEmpty()) return whole + " " + fractionStr;
       if (fraction < tolerance) return String.valueOf(whole);
       
       return String.format("%.2f", q);
    }

    @Override
    public int compareTo(RecipeIngredient other) {
        return this.ingredient.compareTo(other.getIngredient());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        RecipeIngredient that = (RecipeIngredient) o;

        return this.ingredient.equals(that.getIngredient());
    }

    @Override
    public int hashCode() {
        return ingredient.hashCode();
    }

    @Override
    public String toString() {
        String result = String.format("%s: %s %s", ingredient.toString(), formatQuantity(qty), unit.format(qty));

        if (prep) {
            result += ", " + prepNote;
        }

        return result;
    }
}
