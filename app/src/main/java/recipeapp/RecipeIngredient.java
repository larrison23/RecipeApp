package recipeapp;

import java.text.DecimalFormat;

public class RecipeIngredient implements Comparable<RecipeIngredient>{
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
        DecimalFormat df = new DecimalFormat("0.##");

        String result = String.format("%s: %s %s", ingredient.toString(), df.format(qty), unit.format(qty));

        if (prep) {
            result += ", " + prepNote;
        }

        return result;
    }
}
